package com.example.ez_escape.controller;

import android.content.Intent;
import android.view.View;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.CalendarActivity;
import com.example.ez_escape.SettingsActivity;

public class CalendarController implements View.OnClickListener{
    private CalendarActivity calendarActivity;
    private boolean clickedFromCalendarActivity = false;
    private SettingsActivity settingsActivity;
    private boolean clickedFromSettingsActivity = false;

    private AddNewAlertActivity addNewAlertActivity;
    private boolean clickedFromAddNewAlertActivity = false;




    //3 different constructors for when from the 3 different screens/activities a user will
    //press on the new alert button to go to the new alert screen
    public CalendarController(CalendarActivity calendarActivity){
        setCalendarActivity(calendarActivity);
        clickedFromCalendarActivity = true;
        clickedFromSettingsActivity = false;
        clickedFromAddNewAlertActivity = false;
    }
    public CalendarController(SettingsActivity settingsActivity){
        setSettingsActivity(settingsActivity);
        clickedFromAddNewAlertActivity = false;
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = true;
    }
    public CalendarController(AddNewAlertActivity addNewAlertActivity){
        setAddNewAlertActivity(addNewAlertActivity);
        clickedFromAddNewAlertActivity = true;
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = false;
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
}
