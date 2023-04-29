package com.example.ez_escape.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ez_escape.R;
import com.example.ez_escape.controller.EditDeleteAlertController;

import java.util.ArrayList;

public class AlertViewsAdaptor extends ArrayAdapter<AlertViews> {

    private Context context;
    private int resource;

    public AlertViewsAdaptor(Context context, int resource, ArrayList<AlertViews> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView =  layoutInflater.inflate(resource, parent, false);
        TextView textView = convertView.findViewById(R.id.text);

        textView.setText( getItem(position).getTextView() );

        ImageButton imageButton = convertView.findViewById(R.id.imageButton_row);
        imageButton.setOnClickListener( new EditDeleteAlertController() );

        return convertView;
    }
}
