package com.example.ez_escape.controller;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.R;

/**
 * Description of class.
 *
 * @author Name (abc123)
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class Screen2ClearController extends Activity implements View.OnClickListener{
    private EditText date;
    private EditText time;
    private EditText sender;
    private EditText message;
    private AddNewAlertActivity addNewAlertActivity;

    public Screen2ClearController(AddNewAlertActivity addNewAlertActivity){
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
