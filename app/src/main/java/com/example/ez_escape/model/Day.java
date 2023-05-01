package com.example.ez_escape.model;

import com.example.ez_escape.CalendarActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Day {
    int curDate;
    //ArrayList meant to hold alerts for current day
    private ArrayList<Alert> alerts= null;

    //Constructor creates the arrayList

    public Day() {
        //alerts =  new ArrayList<Alert>();
        //Set value to -1 to show invalid date
        this.curDate = -1;
    }

    public Day loadAlerts(int curMonth, int curDay, CalendarActivity activity)  {
        Alert tempAlert = new Alert();


        try {
            alerts = tempAlert.getAlert(DateFormatter(curMonth,curDay), activity);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (alerts == null) {
            return null;
        } else {
            setCurDate(curDay);
        }
        // System.out.println("Successfully loaded:" + curMonth + curDay);
        return this;

    }

    public int getCurDate() {
        return curDate;
    }

    public void setCurDate(int date) {
        curDate = date;
    }

    public String DateFormatter(int month, int date) {
        String s = Month.monthValue(Integer.toString(month)) + "/" + Day.dayValue(Integer.toString(date));
        return s;
    }

    public static String dayValue(String inputDay) {
        String curDay;
        switch (inputDay) {
            case "1":
                curDay = "01";
                break;
            case "2":
                curDay = "02";
                break;
            case "3":
                curDay = "03";
                break;
            case "4":
                curDay = "04";
                break;
            case "5":
                curDay = "05";
                break;
            case "6":
                curDay = "06";
                break;
            case "7":
                curDay = "07";
                break;
            case "8":
                curDay = "08";
                break;
            case "9":
                curDay = "09";
                break;
            default:
                curDay = inputDay;
                break;
        }
        return curDay;
    }
}
