package com.example.ez_escape.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ez_escape.R;

import java.util.ArrayList;

/**
 * This class is what implements row by row of the views inside the list view
 *
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */
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

        return convertView;
    }
}
