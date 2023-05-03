package com.example.ez_escape.controller;

import static com.example.ez_escape.model.GlobalAlarmData.getGlobalAlarmData;

import android.app.AlarmManager;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.R;
import com.example.ez_escape.model.Alert;
import com.example.ez_escape.model.Day;
import com.example.ez_escape.model.GlobalAlarmData;
import com.example.ez_escape.model.Month;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Used by the NewAlertActivity for the save button. Upon clicking the save button, a new Alert object
 * will be made and write it's data to a new file in the phone's files. Also, a new alarm is made for the new alert made.
 * (The notifications are based around the Alarm class. A time is set for the Alarm to go off.
 * Once it does, the onReceive() method is called which is inside of the Alert Receiver class)
 *
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */

public class SaveController implements View.OnClickListener {

    private EditText date;
    private EditText time;
    private EditText sender;
    private EditText message;
    private AddNewAlertActivity addNewAlertActivity;
    private AlarmManager alarmManager;

    private static CalendarView getDay;

    public SaveController(AddNewAlertActivity addNewAlertActivity, AlarmManager alarmManager){
        this.alarmManager = alarmManager;
        this.addNewAlertActivity = addNewAlertActivity;
        date = addNewAlertActivity.findViewById(R.id.editTextDate);
        time = addNewAlertActivity.findViewById(R.id.editTextTime);
        sender = addNewAlertActivity.findViewById(R.id.editTextTextPersonName);
        message = addNewAlertActivity.findViewById(R.id.editTextTextPersonName2);

    }


    public SaveController(AddNewAlertActivity addNewAlertActivity){
        this.addNewAlertActivity = addNewAlertActivity;
        date = addNewAlertActivity.findViewById(R.id.editTextDate);
        time = addNewAlertActivity.findViewById(R.id.editTextTime);
        sender = addNewAlertActivity.findViewById(R.id.editTextTextPersonName);
        message = addNewAlertActivity.findViewById(R.id.editTextTextPersonName2);

    }


    @Override
    public void onClick(View view) {
        String inputDate = String.valueOf(date.getText());
        String inputTime = String.valueOf(time.getText());
        String inputSender = String.valueOf(sender.getText());
        String inputMessage = String.valueOf(message.getText());

        //see MainActivityController.java > onClick() and see the if-else statement
        //note: if needed, access text in "date" with addNewAlertActivity.getUserInput(date)

        // Having "return" here will allow user to go back and fill in missing/incorrect info without having everything else erased.
        if(addNewAlertActivity.isEmpty(date) || !addNewAlertActivity.isValid(date, "^(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input date. Either input is " +
                    "empty or does not match format: MM/DD", Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        else if(addNewAlertActivity.isEmpty(sender)){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for sender. Input is EMPTY", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else if(addNewAlertActivity.isEmpty(message)){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for message. Input is EMPTY", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        else if(addNewAlertActivity.isEmpty(time) || !addNewAlertActivity.isValid(time, "^(0?[0-9]|1[0-9]|2[0-4]):[0-5][0-9]$")){
            Toast t = Toast.makeText(view.getContext(), "Invalid input for time. Either input is " +
                    "empty or does not match format: HH:MM", Toast.LENGTH_SHORT);
            t.show();
            return;

        }

        int min, hour, day, month;
        //timeSplit[0] contains HH (H = hour)
        //timeSplit[1] contains MM (M = minute)
        String timeSplit[] = inputTime.split(":");
        String dateSplit[] = inputDate.split("/");

        hour = Integer.parseInt(timeSplit[0]);
        min = Integer.parseInt(timeSplit[1]);
        day = Integer.parseInt(dateSplit[1]);
        month = Integer.parseInt(dateSplit[0]);

        makeAlarm(hour,day, month, min, inputSender, inputMessage);

        Alert alert = new Alert(inputDate, inputTime, inputSender, inputMessage);
        alert.addAlert(addNewAlertActivity);

        Toast t = Toast.makeText(view.getContext(), "Alert added.", Toast.LENGTH_SHORT);
        t.show();

        System.out.println("Save button added new alert");

    }
    public void makeAlarm(int hour, int day, int month, int minute, String inputSender, String inputMessage){
        Calendar now = Calendar.getInstance();
        Calendar alarm = Calendar.getInstance();

        long difference = 0; //the difference between today the day for the alarm
        long alarmMillis = 0;
        System.out.println(month);
        System.out.println(day);
        System.out.println(hour);

        alarm.set(Calendar.MONTH, month);
        alarm.set(Calendar.DATE, day);
        alarm.set(Calendar.HOUR_OF_DAY, hour);
        alarm.set(Calendar.MINUTE, minute);
        alarm.set(Calendar.SECOND, 0);

        long dayMil = getDay.getDate();

        System.out.println(alarmMillis);
        Date tester = new Date(dayMil);
        String line = tester.toString();
        String lineSplit[] = line.split(" ");
        String year = lineSplit[5];
        String inDate = lineSplit[5] + "/" + Month.monthValue(Integer.toString(month)) + "/" + Day.dayValue(Integer.toString(day)) + " " + Integer.toString(hour) + ":" + Integer.toString(minute) +":00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date curdate = null;
        try {
            curdate = sdf.parse(inDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long curMil = curdate.getTime();

        difference = curMil - dayMil;
        alarmMillis += (difference * 86400000L);

        GlobalAlarmData globalAlarmData = getGlobalAlarmData();
        ArrayList<String> data = globalAlarmData.getData();
        String d = inputSender + "," + inputMessage;
        System.out.println("Data before passing intent is " + d);
        data.add(d);


        addNewAlertActivity.startAlarm(curMil);



    }

    public static void setGetDay(CalendarView in) {
        SaveController.getDay = in;
    }

}

