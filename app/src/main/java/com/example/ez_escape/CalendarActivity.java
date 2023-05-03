package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.SaveController;
import com.example.ez_escape.controller.ViewAlertsController;
import com.example.ez_escape.controller.SettingsController;
import com.example.ez_escape.model.Calendar;

/**
 * This activity allows the user to move through the calender and click day by day to see corresponding alarms
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        //Create Calendar object to hold all alert data
        Calendar calendar = new Calendar(this);
        calendar.loadMonths();

        //Create ArrayList to hold the

        //Create CalendarView object
        CalendarView calendarDisplay = (CalendarView) findViewById(R.id.calendar);
        long millisecondDate = calendarDisplay.getDate();
        int date = (int) (millisecondDate / 31556952000L);
        SaveController.setGetDay(calendarDisplay);

        calendarDisplay.setMinDate(31557952000L * ((long) date));
        calendarDisplay.setMaxDate(31556952000L * ((long) date + 1));

        //Button that sends user to viewAlertActivity Screen
        Button viewAlert = findViewById(R.id.view_alert_button);
        viewAlert.setOnClickListener(new ViewAlertsController(this,calendarDisplay, calendar) );

        //Button that sends user to newAlertActivity Screen
        Button newAlert = findViewById(R.id.new_alert_button);
        newAlert.setOnClickListener(new NewAlertController(this) );

        //Button that sends user to Settings Screen
        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new SettingsController(this) );

    }

    //
}