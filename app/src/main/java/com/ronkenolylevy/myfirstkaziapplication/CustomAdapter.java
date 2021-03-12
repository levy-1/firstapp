package com.ronkenolylevy.myfirstkaziapplication;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<person> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<person> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.person_layout, parent,false);//modify here
            viewHolder = new ViewHolder();
            //modify this block of code
            viewHolder.medtname = (TextView) convertView.findViewById(R.id.edt_name);
            viewHolder.medtemail = (TextView) convertView.findViewById(R.id.edt_email);
            viewHolder.medtpasword = (TextView) convertView.findViewById(R.id.edt_pass);

            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        person person = data.get(position);//modify here
        viewHolder.medtname.setText(person.getName());//modify here
        viewHolder.medtemail.setText(person.getEmail());//modify here
        viewHolder.medtpasword.setText(person.getPassword());//modify here

        return convertView;

    }
    static class ViewHolder {
        TextView medtname;
        TextView medtemail;
        TextView medtpasword;
    }

}

