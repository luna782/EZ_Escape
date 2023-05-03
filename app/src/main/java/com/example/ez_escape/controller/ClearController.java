package com.example.ez_escape.controller;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.R;

/**
 * Used for the AddNewAlertActivity screen to clear the input boxes
 * by setting the text for the EditTexts to an empty string ""
 *
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class ClearController extends Activity implements View.OnClickListener{
    private EditText date;
    private EditText time;
    private EditText sender;
    private EditText message;
    private AddNewAlertActivity addNewAlertActivity;

    public ClearController(AddNewAlertActivity addNewAlertActivity){
            this.addNewAlertActivity = addNewAlertActivity;
            date = addNewAlertActivity.findViewById(R.id.editTextDate);
            time = addNewAlertActivity.findViewById(R.id.editTextTime);
            sender = addNewAlertActivity.findViewById(R.id.editTextTextPersonName);
            message = addNewAlertActivity.findViewById(R.id.editTextTextPersonName2);

    }
    @Override
    public void onClick(View view) {
        date.setText("");
        time.setText("");
        sender.setText("");
        message.setText("");
    }
}
