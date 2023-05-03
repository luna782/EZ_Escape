package com.example.ez_escape.model;

import com.example.ez_escape.CalendarActivity;

import java.util.ArrayList;
import java.util.Date;

/**
 * This model is used to create the calender that is displayed on the calender activity screen
 *
 * UTSA CS 3443 - Final Project
 * Spring 2023
 */
public class Calendar {
    private CalendarActivity calActivity = null;
    private Month months[];

    public Calendar(CalendarActivity activity) {
        int i;
        calActivity = activity;
        months = new Month[13];
    }

    public void loadMonths() {
        int i;
        Alert tempAlert = null;

        for (i = 0; i < months.length; i++) {
            months[i] = new Month();
        }

        for (i = 0; i < months.length; i++) {
            try {
                months[i].loadDays(calActivity, i );
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

        }

    }

    public boolean checkDay(String date) {
        int i;
        String curMonth, curDay;
        String curDate[] = date.split("/");


        ArrayList<Day> dayChecker = new ArrayList<Day>();

        curMonth = Month.monthValue(curDate[0]);
        curDay = Day.dayValue(curDate[1]);


        try {
            dayChecker = months[Integer.parseInt(curMonth)].getDays();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }


        if ((!(dayChecker == null)) || (!dayChecker.isEmpty())) {

            for (i = 0; i < dayChecker.size(); i++) {

                if (Integer.parseInt(curDay) == dayChecker.get(i).getCurDate()) {
                    return true;
                }
            }
        }

        return false;

    }


}
