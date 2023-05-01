package com.example.ez_escape;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.ez_escape.controller.CalendarController;
import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.Screen3ViewAlertsController;
import com.example.ez_escape.controller.SettingsController;
import com.example.ez_escape.model.Calendar;

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

        //Button that sends user to viewAlertActivity Screen
        Button viewAlert = findViewById(R.id.view_alert_button);
        viewAlert.setOnClickListener(new Screen3ViewAlertsController(this,calendarDisplay, calendar) );

        //Button that sends user to newAlertActivity Screen
        Button newAlert = findViewById(R.id.new_alert_button);
        newAlert.setOnClickListener(new NewAlertController(this) );

        //Button that sends user to Settings Screen
        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new SettingsController(this) );

    }

    //
}