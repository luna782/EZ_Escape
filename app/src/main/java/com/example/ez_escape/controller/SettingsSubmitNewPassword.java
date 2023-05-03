package com.example.ez_escape.controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ez_escape.R;
import com.example.ez_escape.SettingsActivity;
import com.example.ez_escape.model.Password;

import java.util.Set;

/**
 * Upon clicking the submit button in the Settings Activity, the new password that was entered in the input box is written to the file that contains the user's password
 *
 *
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class SettingsSubmitNewPassword implements View.OnClickListener{
    private SettingsActivity settingsActivity;
    public SettingsSubmitNewPassword(SettingsActivity settingsActivity){
        setSettingsActivity(settingsActivity);
    }

    @Override
    public void onClick(View view) {
        EditText userInputEditText = settingsActivity.findViewById(R.id.new_password);
        String userInput = String.valueOf(userInputEditText.getText());

        if (userInput.equals("") || userInput.contains(" ") || userInput.contains("\t") || userInput.contains("\n")) {
            Toast t = Toast.makeText(view.getContext(), "Invalid input: password cannot contain spaces, tabs, or newlines.", Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        Password password = new Password();
        password.addNewPassword(settingsActivity, userInput);

        Toast t = Toast.makeText(view.getContext(), "Password successfully changed.", Toast.LENGTH_SHORT);
        t.show();
    }

    public SettingsActivity getSettingsActivity() {
        return settingsActivity;
    }

    public void setSettingsActivity(SettingsActivity settingsActivity) {
        this.settingsActivity = settingsActivity;
    }
}
