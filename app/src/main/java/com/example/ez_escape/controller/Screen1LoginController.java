package com.example.ez_escape.controller;

/**
 * Description of class.
 *
 * @author Name (abc123)
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

import android.view.View;
import android.widget.Toast;

public class Screen1LoginController implements View.OnClickListener{
    private String message;
    private String password;
    //Method will be called on creation of application;
    public Screen1LoginController(String password){
        this.message = "Wrong Password";
        this.password = password;
    }
    public void onClick(View view) {
        //Only logic for the onclick method if statement; Implement actual function calls later for getting text
        if (password.equals(getInputFromTextBox)) {
            //Change Activity to Screen 2
        } else {
            //Tell User that the password is incorrect
            //Currently using Toast to do this
            Toast t = Toast.makeText(view.getContext(), this.message, Toast.LENGTH_SHORT);
            t.show();
        }

    }

    public void setPassword(String password) {
        this.password = password;
    }

}
