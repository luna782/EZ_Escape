package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.ez_escape.controller.CalendarController;
import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.Screen3ViewAlertsController;
import com.example.ez_escape.controller.SettingsController;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //Create Calendar controller
        //CalendarController calendarCtrl = new CalendarController(this);

        //Create CalendarView object
        CalendarView calendar = findViewById(R.id.calendar);

        //Button that sends user to viewAlertActivity Screen
        Button viewAlert = findViewById(R.id.view_alert_button);
        viewAlert.setOnClickListener(new Screen3ViewAlertsController(this,calendar) );


        //Button that sends user to newAlertActivity Screen
        Button newAlert = findViewById(R.id.new_alert_button);
        newAlert.setOnClickListener(new NewAlertController(this) );

        //Button that sends user to newAlertActivity Screen
        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new SettingsController(this) );

    }
}