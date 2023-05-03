package com.example.ez_escape.model;

import com.example.ez_escape.CalendarActivity;

import java.util.ArrayList;

/**
 * This model is used to help create the calender displayed in the calender activity screen
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class Month {
    private int maxDays = 31;
    private ArrayList<Day> days= null;
    private int curMonth = 0;

    //Constructor creates the arrayList
    public Month() {
        days = new ArrayList<Day>();
    }

    public void loadDays(CalendarActivity activity, int month) {
        int i;
        Day tempDay = null;

        for (i = 0; i < maxDays; i++) {
            //reset to null
            tempDay = new Day();

            tempDay = tempDay.loadAlerts(month, (i + 1), activity);
            if (tempDay == null) {
                continue;
            }
            //Should only add when day does not equals null
            days.add(tempDay);
        }
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public static String monthValue(String inputMonth) {
        String curMonth;
        switch (inputMonth) {
            case "1":
                curMonth = "01";
                break;
            case "2":
                curMonth = "02";
                break;
            case "3":
                curMonth = "03";
                break;
            case "4":
                curMonth = "04";
                break;
            case "5":
                curMonth = "05";
                break;
            case "6":
                curMonth = "06";
                break;
            case "7":
                curMonth = "07";
                break;
            case "8":
                curMonth = "08";
                break;
            case "9":
                curMonth = "09";
                break;
            default:
                curMonth = inputMonth;
                break;
        }
        return curMonth;
    }

    public static int monthToNum(String inputMonth) {
        int curMonth;
        switch (inputMonth) {
            case "Jan":
                curMonth = 1;
                break;
            case "Feb":
                curMonth = 2;
                break;
            case "Mar":
                curMonth = 3;
                break;
            case "Apr":
                curMonth = 4;
                break;
            case "May":
                curMonth = 5;
                break;
            case "Jun":
                curMonth = 6;
                break;
            case "Jul":
                curMonth = 7;
                break;
            case "Aug":
                curMonth = 8;
                break;
            case "Sep":
                curMonth = 9;
                break;
            case "Oct":
                curMonth = 10;
                break;
            case "Nov":
                curMonth = 11;
                break;
            case "Dec":
                curMonth = 12;
                break;
            default:
                curMonth = -1;
                break;
        }
        return curMonth;
    }
}
