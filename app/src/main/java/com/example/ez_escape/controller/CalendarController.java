package com.example.ez_escape.controller;

import android.content.Intent;
import android.view.View;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.CalendarActivity;
import com.example.ez_escape.SettingsActivity;
import com.example.ez_escape.ViewAlertActivity;

public class CalendarController implements View.OnClickListener{
    private CalendarActivity calendarActivity;
    private boolean clickedFromCalendarActivity = false;
    private SettingsActivity settingsActivity;
    private boolean clickedFromSettingsActivity = false;

    private AddNewAlertActivity addNewAlertActivity;
    private boolean clickedFromAddNewAlertActivity = false;

    private ViewAlertActivity viewAlertActivity;
    private boolean clickedFromViewAlertActivity = false;




    //4 different constructors for when from the 4 different screens/activities a user will
    //press on the calendar  button to go to the calendar screen

    public CalendarController(ViewAlertActivity viewAlertActivity){
        setViewAlertActivity(viewAlertActivity);
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = false;
        clickedFromAddNewAlertActivity = false;
        clickedFromViewAlertActivity = true;
    }
    public CalendarController(CalendarActivity calendarActivity){
        setCalendarActivity(calendarActivity);
        clickedFromCalendarActivity = true;
        clickedFromSettingsActivity = false;
        clickedFromAddNewAlertActivity = false;
        clickedFromViewAlertActivity = false;

    }
    public CalendarController(SettingsActivity settingsActivity){
        setSettingsActivity(settingsActivity);
        clickedFromAddNewAlertActivity = false;
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = true;
        clickedFromViewAlertActivity = false;

    }
    public CalendarController(AddNewAlertActivity addNewAlertActivity){
        setAddNewAlertActivity(addNewAlertActivity);
        clickedFromAddNewAlertActivity = true;
        clickedFromCalendarActivity = false;
        clickedFromSettingsActivity = false;
        clickedFromViewAlertActivity = false;

    }

    @Override
    public void onClick(View view) {
        if(clickedFromAddNewAlertActivity == true){
            Intent intent = new Intent(addNewAlertActivity, CalendarActivity.class );
            addNewAlertActivity.startActivity(intent);
        }
        else if(clickedFromCalendarActivity == true){
            Intent intent = new Intent(calendarActivity, CalendarActivity.class );
            calendarActivity.startActivity(intent);
        }
        else if(clickedFromSettingsActivity == true){
            Intent intent = new Intent(settingsActivity, CalendarActivity.class );
            settingsActivity.startActivity(intent);
        }
        else if(clickedFromViewAlertActivity == true){
            Intent intent = new Intent(viewAlertActivity, CalendarActivity.class );
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
