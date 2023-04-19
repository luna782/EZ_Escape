package com.example.ez_escape.controller;

import android.view.View;
import android.widget.EditText;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.R;
import com.example.ez_escape.model.Alert;

/**
 * Description of class.
 *
 * @author Name (abc123)
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class Screen2SaveController implements View.OnClickListener {

    private EditText date;
    private EditText time;
    private EditText sender;
    private EditText message;
    private AddNewAlertActivity addNewAlertActivity;

    public Screen2SaveController(AddNewAlertActivity addNewAlertActivity){
        this.addNewAlertActivity = addNewAlertActivity;
        date = addNewAlertActivity.findViewById(R.id.editTextDate);
        time = addNewAlertActivity.findViewById(R.id.editTextTime);
        sender = addNewAlertActivity.findViewById(R.id.editTextTextPersonName);
        message = addNewAlertActivity.findViewById(R.id.editTextTextPersonName2);

    }


    @Override
    public void onClick(View view) {
/*      I don't think the statements in this block are needed
        String inputDate = String.valueOf(date.getText());
        String inputTime = String.valueOf(time.getText());
        String inputSender = String.valueOf(sender.getText());
        String inputMessage = String.valueOf(message.getText()); */

        // Check if any fields are empty (empty string or contains only whitespace).
        //      This means user forgot to enter info for one of them.
        //      If so, show toast like "one or more fields incomplete" and return. This
        //      will allow user to go back and fill in missing info without erasing everything else.
        //<type code here>

        // After this, also check if any input is invalid (incorrect format -- i.e., for date & time)
        //      If so, show toast like "Invalid input for XXXX" and return.
        //<type code here>

        //see MainActivityController.java > onClick() and see the if-else statement
        //note: if needed, access text in "date" with addNewAlertActivity.getUserInput(date)




        //Alert newAlert = new Alert()
    }
}
