package com.example.ez_escape.model;

import java.util.ArrayList;

public class GlobalAlarmData {
    public static GlobalAlarmData globalAlarmDataInstance = null;
    private ArrayList<String> messages = new ArrayList<>();
    private ArrayList<String> senders = new ArrayList<>();
    private ArrayList<Integer> dates = new ArrayList<>();
    private ArrayList<Integer> hours = new ArrayList<>();
    private ArrayList<Integer> minutes = new ArrayList<>();


    public static GlobalAlarmData getGlobalAlarmData()
    {
        if(globalAlarmDataInstance == null){
            globalAlarmDataInstance = new GlobalAlarmData();
        }
        return globalAlarmDataInstance;
    }

    public ArrayList<Integer> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Integer> dates) {
        this.dates = dates;
    }

    public ArrayList<Integer> getHours() {
        return hours;
    }

    public ArrayList<Integer> getMinutes() {
        return minutes;
    }

    public void setMinutes(ArrayList<Integer> minutes) {
        this.minutes = minutes;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public ArrayList<String> getSenders() {
        return senders;
    }

    public void setSenders(ArrayList<String> senders) {
        this.senders = senders;
    }

}
