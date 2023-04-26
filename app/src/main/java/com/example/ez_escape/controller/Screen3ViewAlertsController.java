package com.example.ez_escape.controller;

import android.content.Intent;
import android.view.View;
import android.widget.CalendarView;

import com.example.ez_escape.CalendarActivity;
import com.example.ez_escape.ViewAlertActivity;

import com.example.ez_escape.model.Alert;

/**
 * Class meant to send the user to the view alerts screen, with passing the data of the current day.
 * If there is no data associated with the day, returns a Toast.
 *
 * @author Name (abc123)
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class Screen3ViewAlertsController implements View.OnClickListener {
    private CalendarActivity calActivity;
    private CalendarView calView;

    Alert alertChecker;
    private long date;

    public Screen3ViewAlertsController(CalendarActivity inputActivity, CalendarView inputCalendar) {
        this.calActivity = inputActivity;
        this.calView = inputCalendar;
    }
    @Override
    public void onClick(View view) {
        date = calView.getDate();

        //use alert to read in alerts, then check if there are valid alerts,
        //if there are, then pass it to the next screen,
        //if not, then send toast to user


        Intent intent = new Intent(calActivity, ViewAlertActivity.class);
        calActivity.startActivity(intent);
    }
}
