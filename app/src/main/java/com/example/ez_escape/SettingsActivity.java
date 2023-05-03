package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.ez_escape.controller.CalendarController;
import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.SettingsController;
import com.example.ez_escape.controller.SettingsSubmitNewPassword;
import com.example.ez_escape.model.Password;

import java.io.IOException;

/**
 * This activity allows the user to view their current password and change it by inputting a new one
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Password passwordInstance = new Password();
        TextView currPassword = findViewById(R.id.current_password);
        String userPass = "";
        try {
            userPass = passwordInstance.readUserPassword(this);
            currPassword.setText( userPass );
        } catch (IOException e) {
            System.out.println("Settings Activity could not read what the user's password is");
            if(userPass == null || userPass.equals("")){
                System.out.println("User password read in Settings Activity is null");
            }
            throw new RuntimeException(e);
        }
        Button submitNewPasswordButton = findViewById(R.id.submit_new_password);
        submitNewPasswordButton.setOnClickListener( new SettingsSubmitNewPassword(this) );

        //Button that sends user to viewAlertActivity Screen
        Button calendar = findViewById(R.id.view_schedule_button);
        calendar.setOnClickListener(new CalendarController(this) );


        //Button that sends user to newAlertActivity Screen
        Button newAlert = findViewById(R.id.new_alert_button);
        newAlert.setOnClickListener(new NewAlertController(this) );

        //Button that sends user to newAlertActivity Screen
        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new SettingsController(this) );

    }
}