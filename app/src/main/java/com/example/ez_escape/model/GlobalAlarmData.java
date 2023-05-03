package com.example.ez_escape.model;

import java.util.ArrayList;

/**
 * This model follows the singleton pattern to help pass data needed when creating and starting an alarm
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class GlobalAlarmData {
    public static GlobalAlarmData globalAlarmDataInstance = null;

    //each string in the data array list is comma separated values that is needed for the alarms/notifications
    //sender,message
    private ArrayList<String> data = new ArrayList<>();

    public static GlobalAlarmData getGlobalAlarmData()
    {
        if(globalAlarmDataInstance == null){
            globalAlarmDataInstance = new GlobalAlarmData();
        }
        return globalAlarmDataInstance;
    }



    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

}
