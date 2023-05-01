package com.example.ez_escape.controller;

import android.content.Intent;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.ez_escape.CalendarActivity;
import com.example.ez_escape.ViewAlertActivity;

import com.example.ez_escape.model.Calendar;
import com.example.ez_escape.model.Day;
import com.example.ez_escape.model.Month;

import java.util.Date;

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

    private Calendar calendar;

    private String message;
    private String curDate;


    public Screen3ViewAlertsController(CalendarActivity inputActivity, CalendarView inputCalendarDisplay,Calendar inputCalendar) {
        this.calActivity = inputActivity;
        this.calView = inputCalendarDisplay;
        this.calendar = inputCalendar;
        this.message = "No Alerts for the selected day";

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String month = Month.monthValue(String.valueOf(i1 + 1));
                String day = Day.dayValue(String.valueOf(i2));
                curDate = month + "/" + day;
            }
        });

    }
    @Override
    public void onClick(View view) {
        //Date is currently in milliseconds from 1970
        boolean alertCheck;
        if (curDate == null) {
            long x = calView.getDate();
            String wholeDate;
            String splitDate[];
            Date tempDate = new Date(x);
            wholeDate = tempDate.toString();
            splitDate = wholeDate.split(" ");
            String month = Month.monthValue(String.valueOf(Month.monthToNum(splitDate[1])));
            String day = Day.dayValue(splitDate[2]);
            curDate = month + "/" + day;
            Toast r = Toast.makeText(view.getContext(), curDate, Toast.LENGTH_SHORT);
            r.show();
        }

        alertCheck = calendar.checkDay(curDate);

        if (alertCheck) {
            Intent intent = new Intent(calActivity, ViewAlertActivity.class);
            intent.putExtra("date", curDate);
            calActivity.startActivity(intent);
        } else {
            Toast t = Toast.makeText(view.getContext(), this.message, Toast.LENGTH_SHORT);
            t.show();
        }

    }

}
