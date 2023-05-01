package com.example.ez_escape.model;

import com.example.ez_escape.CalendarActivity;

import java.util.ArrayList;

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
        //dont need this?
        //curMonth = month + 1;
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
}
