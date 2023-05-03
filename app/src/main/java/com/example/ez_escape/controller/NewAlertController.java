package com.example.ez_escape.controller;

import android.content.Intent;
import android.view.View;

import com.example.ez_escape.ViewAlertActivity;
import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.CalendarActivity;
import com.example.ez_escape.SettingsActivity;

/**
 * NewAlertController responsible for starting the AddNewAlertActivity when clicking on the New Alert button from different screens
 *
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class NewAlertController implements View.OnClickListener{
    private CalendarActivity calendarActivity;
    private boolean clickedFromCalendarActivity = false;
    private SettingsActivity settingsActivity;
    private boolean clickedFromSettingsActivity = false;

    private AddNewAlertActivity addNewAlertActivity;
    private boolean clickedFromAddNewAlertActivity = false;

    private ViewAlertActivity viewAlertActivity;
    private boolean clickedFromViewAlertActivity = false;




    //4 different constructors for when from the 4 different screens/activities a user will
    //press on the new alert button to go to the new alert screen

    public NewAlertController(ViewAlertActivity viewAlertActivity){
        setViewAlertActivity(viewAlertActivity);
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = false;
        clickedFromAddNewAlertActivity = false;
        clickedFromViewAlertActivity = true;
    }
    public NewAlertController(CalendarActivity calendarActivity){
        setCalendarActivity(calendarActivity);
        clickedFromCalendarActivity = true;
        clickedFromSettingsActivity = false;
        clickedFromAddNewAlertActivity = false;
        clickedFromViewAlertActivity = false;

    }
    public NewAlertController(SettingsActivity settingsActivity){
        setSettingsActivity(settingsActivity);
        clickedFromAddNewAlertActivity = false;
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = true;
        clickedFromViewAlertActivity = false;

    }
    public NewAlertController(AddNewAlertActivity addNewAlertActivity){
        setAddNewAlertActivity(addNewAlertActivity);
        clickedFromAddNewAlertActivity = true;
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = false;
        clickedFromViewAlertActivity = false;

    }

    @Override
    public void onClick(View view) {
        if(clickedFromAddNewAlertActivity == true){
            Intent intent = new Intent(addNewAlertActivity, AddNewAlertActivity.class );
            addNewAlertActivity.startActivity(intent);
        }
        else if(clickedFromCalendarActivity == true){
            Intent intent = new Intent(calendarActivity, AddNewAlertActivity.class );
            calendarActivity.startActivity(intent);
        }
        else if(clickedFromSettingsActivity == true){
            Intent intent = new Intent(settingsActivity, AddNewAlertActivity.class );
            settingsActivity.startActivity(intent);
        }
        else if(clickedFromViewAlertActivity == true){
            Intent intent = new Intent(viewAlertActivity, AddNewAlertActivity.class );
            viewAlertActivity.startActivity(intent);
        }
    }

    public AddNewAlertActivity getAddNewAlertActivity() {
        return addNewAlertActivity;
    }

    public void setAddNewAlertActivity(AddNewAlertActivity addNewAlertActivity) {
        this.addNewAlertActivity = addNewAlertActivity;
    }

    public CalendarActivity getCalendarActivity() {
        return calendarActivity;
    }

    public void setCalendarActivity(CalendarActivity calendarActivity) {
        this.calendarActivity = calendarActivity;
    }

    public SettingsActivity getSettingsActivity() {
        return settingsActivity;
    }

    public void setSettingsActivity(SettingsActivity settingsActivity) {
        this.settingsActivity = settingsActivity;
    }

    public ViewAlertActivity getViewAlertActivity() {
        return viewAlertActivity;
    }

    public void setViewAlertActivity(ViewAlertActivity viewAlertActivity) {
        this.viewAlertActivity = viewAlertActivity;
    }
}
