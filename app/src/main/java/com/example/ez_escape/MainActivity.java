package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.controller.MainActivityController;
import com.example.ez_escape.model.Password;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * This activity is the first screen that is loaded and before going to the next screen, the user has to input their password
 * if password has not been made, the user can click the button to proceed to the calender screen
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class MainActivity extends AppCompatActivity {

    EditText passwordInputButton;
    private String userPasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the input that the
        passwordInputButton = findViewById(R.id.editTextTextPassword);


        //Read from the password.csv file using the Password class model
        //if string returned equals null, then no password is assigned
        //otherwise, the string returned is the user's password
        Password passwordInstance = new Password();
        String password = "";

        try {
            password = passwordInstance.readUserPassword(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Button screen1Login = findViewById(R.id.enterButton);
        screen1Login.setOnClickListener( new MainActivityController(password, this) );

    }

    public String getUserPasswordInput(){
        userPasswordInput = String.valueOf(passwordInputButton.getText());
        return this.userPasswordInput;
    }
}