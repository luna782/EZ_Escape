package com.example.ez_escape.controller;

/*
 * Description of class.
 *
 * @author Name (abc123)
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.ez_escape.CalendarActivity;
import com.example.ez_escape.MainActivity;

public class MainActivityController implements View.OnClickListener{
    private String message;
    private String password;
    private MainActivity mainActivity;
    //Method will be called on creation of application;
    public MainActivityController(String password, MainActivity mainActivity){
        this.message = "Wrong Password";
        this.password = password;
        this.mainActivity = mainActivity;
    }

    public void onClick(View view ) {

        //Only logic for the onclick method if statement; Implement actual function calls later for getting text
        if (password.equals(mainActivity.getUserPasswordInput())) {
            //Change Activity to Screen 2
//            Toast t = Toast.makeText(view.getContext(), "Password match", Toast.LENGTH_SHORT);
//            t.show();
            //with successful enter of correct password, go to Calendar activity screen
            Intent intent = new Intent(mainActivity, CalendarActivity.class);
            mainActivity.startActivity(intent);
        }
        else {
            //Tell User that the password is incorrect
            //Currently using Toast to do this
            Toast t = Toast.makeText(view.getContext(), this.message, Toast.LENGTH_SHORT);
            t.show();
        }

    }

    // FIXME: remove this function if not used
    public void setPassword(String password) {
        this.password = password;
    }


}
