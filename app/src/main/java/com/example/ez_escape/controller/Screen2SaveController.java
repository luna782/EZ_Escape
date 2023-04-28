package com.example.ez_escape.controller;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        String inputDate = String.valueOf(date.getText());
        String inputTime = String.valueOf(time.getText());
        String inputSender = String.valueOf(sender.getText());
        String inputMessage = String.valueOf(message.getText());


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


        if(inputDate.equals("") || !addNewAlertActivity.isValid(date, "[0-1][0-9]/[0-3][0-9]")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input date. Either input is " +
                    "empty or does not match format: MM/DD", Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        else if(inputSender.equals("")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for sender. Input is EMPTY", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else if(inputMessage.equals("")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for message. Input is EMPTY", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else if(inputTime.equals("") || !addNewAlertActivity.isValid(time, "[0-2][0-9]:[0-5][0-9]")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for time. Either input is " +
                    "empty or does not match format: ##:## where its hour then minute", Toast.LENGTH_SHORT);
            t.show();
            return;

        }

        Alert alert = new Alert(inputDate, inputTime, inputSender, inputMessage);
        alert.addAlert(addNewAlertActivity);
        System.out.println("Save button added new alert");

    }
}
