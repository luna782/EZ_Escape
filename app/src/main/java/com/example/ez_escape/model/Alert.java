package com.example.ez_escape.model;

public class Alert {
    private String date;
    private String time;
    private String sender;
    private String message;


    public Alert(String date, String time, String sender, String message){
        setDate(date);
        setTime(time);
        setSender(sender);
        setMessage(message);
    }

    /**
     * addAlert is responsible for writing the data of the passed in Alert object to alerts.csv in the assets folder
     * @param newAlert
     */
    public void addAlert(Alert newAlert){
        //figure out how to write

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
