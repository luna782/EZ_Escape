package com.example.ez_escape.controller;

import android.app.AlarmManager;
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
    private AlarmManager alarmManager;

    public Screen2SaveController(AddNewAlertActivity addNewAlertActivity, AlarmManager alarmManager){
        this.alarmManager = alarmManager;
        this.addNewAlertActivity = addNewAlertActivity;
        date = addNewAlertActivity.findViewById(R.id.editTextDate);
        time = addNewAlertActivity.findViewById(R.id.editTextTime);
        sender = addNewAlertActivity.findViewById(R.id.editTextTextPersonName);
        message = addNewAlertActivity.findViewById(R.id.editTextTextPersonName2);

    }


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

        //see MainActivityController.java > onClick() and see the if-else statement
        //note: if needed, access text in "date" with addNewAlertActivity.getUserInput(date)

        // Having "return" here will allow user to go back and fill in missing/incorrect info without having everything else erased.
        if(addNewAlertActivity.isEmpty(date) || !addNewAlertActivity.isValid(date, "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input date. Either input is " +
                    "empty or does not match format: MM/DD", Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        else if(addNewAlertActivity.isEmpty(sender)){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for sender. Input is EMPTY", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else if(addNewAlertActivity.isEmpty(message)){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for message. Input is EMPTY", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else if(addNewAlertActivity.isEmpty(time) || !addNewAlertActivity.isValid(time, "^(0?[0-9]|1[0-9]|2[0-4]):[0-5][0-9]$")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for time. Either input is " +
                    "empty or does not match format: HH:MM", Toast.LENGTH_SHORT);
            t.show();
            return;

        }


        Alert alert = new Alert(inputDate, inputTime, inputSender, inputMessage);
        alert.addAlert(addNewAlertActivity);

        Toast t = Toast.makeText(view.getContext(), "Alert added.", Toast.LENGTH_SHORT);
        t.show();

        System.out.println("Save button added new alert");

    }
}
