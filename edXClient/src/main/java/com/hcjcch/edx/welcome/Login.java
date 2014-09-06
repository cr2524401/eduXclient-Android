package com.hcjcch.edx.welcome;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.andreabaccega.widget.FormEditText;
import com.hcjcch.edx.common.StaticVariables;
import com.hcjcch.edx.edxclient.MainActivity;
import com.hcjcch.edx.edxclient.R;
import com.hcjcch.edx.event.NetworkChangeEvent;
import com.hcjcch.edx.utils.EdxHttpClient;
import com.hcjcch.edx.utils.NetworkJudgment;
import com.loopj.android.http.DataAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.apache.http.Header;

import de.greenrobot.event.EventBus;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;

/**
 * Created by hcjcch on 2014/8/24.
 */

@EActivity(R.layout.login)
public class Login extends Activity {

    private String TAG = "LOGIN";
    @ViewById(R.id.et_email)
    FormEditText et_email;
    @ViewById(R.id.activity_login_passwd)
    FormEditText et_passwd;
    @ViewById(R.id.activity_login)
    Button et_login;
    @ViewById(R.id.activity_login_progress)
    SmoothProgressBar progressBar;
    @ViewById(R.id.activity_login_progress_layout)
    LinearLayout activity_login_progress_layout;

    @AfterInject
    void afterConstructor() {
        EventBus.getDefault().register(this);
    }

    private void init(){
    }
    @AfterViews
    void contentView() {
        init();
        activity_login_progress_layout.setVisibility(View.GONE);
    }

    public void onEventMainThread(NetworkChangeEvent networkChangeEvent) {
        boolean isNetworkConnected = networkChangeEvent.isNetworkConnected();
        if (isNetworkConnected) {

        } else {

        }
    }

    @Click(R.id.activity_login)
    void loginClick() {
        onClickCheckEmailAndPasswordIsNull();
    }

    private void onClickCheckEmailAndPasswordIsNull() {
        FormEditText[] allFields = {et_email, et_passwd};
        boolean allValid = true;

        for (FormEditText field : allFields) {
            allValid = field.testValidity() && allValid;
        }
        if (allValid) {
            if (NetworkJudgment.isNetworkConnected(this)) {
                String email = et_email.getText().toString();
                String userName = email.substring(0,email.indexOf("@"));
                Log.i(TAG,userName);
                login(userName, et_passwd.getText().toString(), new LoginCallBack() {
                    @Override
                    public void loginSucces() {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void loginFailure() {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            } else {

            }

        } else {
            et_email.requestFocus();
        }
    }

    private void onclickCheckPasswordCorrect(String password) {
        et_passwd.addValidator(new PasswdValidator(password));
        FormEditText[] allFields = {et_passwd};
        boolean allValid = true;
        for (FormEditText field : allFields) {
            allValid = field.testValidity() && allValid;
        }
        if (allValid) {

        } else {
            et_email.requestFocus();
        }
    }

    private void login(String email, String passwd, final LoginCallBack callBack) {
        RequestParams params = new RequestParams();
        params.put("username", email);
        params.put("password", passwd);
        params.put("csrfmiddlewaretoken", "gebbXezhktoWpnPoJSu9Rn9QTvQc9pV3");
        params.put("next", "");
        params.put("submit", "Log in");
        EdxHttpClient.post(StaticVariables.LoginUrl, params, new DataAsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                activity_login_progress_layout.setVisibility(View.VISIBLE);
                super.onStart();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(Login.this, "登录成功!", Toast.LENGTH_SHORT).show();
                callBack.loginSucces();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //Log.i(TAG, new String(responseBody));
                callBack.loginFailure();
                Toast.makeText(Login.this, getString(R.string.login_failure), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                activity_login_progress_layout.setVisibility(View.GONE);
                super.onFinish();
            }
        });
    }

    private interface LoginCallBack {
        void loginSucces();
        void loginFailure();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}