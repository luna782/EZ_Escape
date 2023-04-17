package com.example.ez_escape.controller;

import android.view.View;
import android.widget.EditText;

import com.example.ez_escape.AddNewAlertActivity;

/**
 * Description of class.
 *
 * @author Name (abc123)
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class Screen2ClearController implements View.OnClickListener{
        EditText date;
        EditText time;
        EditText sender;
        EditText message;
        AddNewAlertActivity addNewAlertActivity;
    }
    public Screen2ClearController(AddNewAlertActivity addNewAlertActivity){
            this.addNewAlertActivity = addNewAlertActivity;
            date = findViewById(addNewAlertActivity.R.id.date);
    }
    @Override
    public void onClick(View view) {
        textView.setText(" ");
    }

    @Override
    public void onClick(View view) {

    }
}
