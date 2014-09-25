package com.hcjcch.edx.welcome;

import android.text.TextUtils;
import android.widget.EditText;

import com.andreabaccega.formedittextvalidator.Validator;

/**
 * Created by hcjcch on 2014/9/1.
 */

public class PasswdValidator extends Validator {

    private String passwd;
    /*public PasswdValidator(String _customErrorMessage) {
        super(_customErrorMessage);

    }*/

    public PasswdValidator(String passwd) {
        super("密码错误!");
        this.passwd = passwd;
    }

    @Override
    public boolean isValid(EditText editText) {
        boolean isCorrect = TextUtils.equals(editText.getText(), passwd);
        return isCorrect;
    }
}
