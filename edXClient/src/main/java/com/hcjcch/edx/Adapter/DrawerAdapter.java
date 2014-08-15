package com.hcjcch.edx.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcjcch.edx.edxclient.R;

import java.util.ArrayList;

/**
 * Created by hcjcch on 2014/8/13.
 */

public class DrawerAdapter extends BaseAdapter {

    private Context context;
    private String[] drawerItems;
    private ArrayList<Integer> drawables;

    public DrawerAdapter() {

    }

    public DrawerAdapter(Context context, String[] drawerItems, ArrayList<Integer> drawables) {
        this.context = context;
        this.drawerItems = drawerItems;
        this.drawables = drawables;
    }

    @Override
    public int getCount() {
        return drawerItems.length;
    }

    @Override
    public Object getItem(int position) {
        return drawerItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_drawer,parent,false);
        TextView textView = (TextView)convertView.findViewById(R.id.item_drawer_textview);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.item_drawer_icon);
        textView.setText(drawerItems[position]);
        imageView.setImageResource(drawables.get(position));
        return convertView;
    }
}
