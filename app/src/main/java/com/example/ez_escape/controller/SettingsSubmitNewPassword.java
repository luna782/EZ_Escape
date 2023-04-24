package com.example.ez_escape.controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.R;
import com.example.ez_escape.SettingsActivity;
import com.example.ez_escape.model.Password;

import java.util.Set;

public class SettingsSubmitNewPassword implements View.OnClickListener{
    private SettingsActivity settingsActivity;
    public SettingsSubmitNewPassword(SettingsActivity settingsActivity){
        setSettingsActivity(settingsActivity);
    }

    @Override
    public void onClick(View view) {
        EditText userInputEditText = settingsActivity.findViewById(R.id.new_password);

        //handle bad input if possible
//        if(userInput.getText().equals()){
//
//        }
        String userInput = String.valueOf(userInputEditText.getText());

        Password password = new Password();
        password.addNewPassword(settingsActivity, userInput);
    }

    public SettingsActivity getSettingsActivity() {
        return settingsActivity;
    }

    public void setSettingsActivity(SettingsActivity settingsActivity) {
        this.settingsActivity = settingsActivity;
    }
}
