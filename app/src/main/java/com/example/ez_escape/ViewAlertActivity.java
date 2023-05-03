package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ez_escape.controller.CalendarController;
import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.SettingsController;
import com.example.ez_escape.model.Alert;
import com.example.ez_escape.model.AlertViews;
import com.example.ez_escape.model.AlertViewsAdaptor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This activity allows the user to view the alerts for the day they clicked on the calender screen
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class ViewAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_alert);

        Button calendar_button = findViewById(R.id.view_schedule_button);
        calendar_button.setOnClickListener( new CalendarController(this) );

        Button newAlert_button = findViewById(R.id.new_alert_button);
        newAlert_button.setOnClickListener( new NewAlertController(this) );

        Button settings_button = findViewById(R.id.settings_button);
        settings_button.setOnClickListener( new SettingsController(this));


        //UNCOMMENT BELOW AFTER IMPLEMENTING PASSING THE DATE THROUGH INTENT
        String date = "";
        date = getIntent().getStringExtra("date");

        TextView title = findViewById(R.id.title);
        title.setText(date);

        ListView listView = findViewById(R.id.list_view);
        Alert tempAlert = new Alert();
        ArrayList<Alert> alerts;
        try {
            alerts = tempAlert.getAlert(date, this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<AlertViews> alertViews = new ArrayList<>();

        int i;
        for(i = 0; i < alerts.size(); i++){
            String text = alerts.get(i).getTime() + " from " + alerts.get(i).getSender();
            AlertViews newAlertView = new AlertViews(text);
            alertViews.add(newAlertView);
        }

        AlertViewsAdaptor alertViewsAdaptor = new AlertViewsAdaptor(this, R.layout.list_row, alertViews);
        listView.setAdapter(alertViewsAdaptor);
    }
}