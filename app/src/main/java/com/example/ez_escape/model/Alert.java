package com.example.ez_escape.model;

import android.content.res.AssetManager;

import com.example.ez_escape.AddNewAlertActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Scanner;

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
     * addAlert is responsible for WRITING the data of the passed in Alert object to a .csv
     * Data is stored as comma separated values (.csv file in assets folder)
     * Format of alerts.csv:
     * date,time,sender,message
     *
     * YOU CANNOT WRITE TO FILES IN ASSETS FOLDER
     *
     * @param  newAlert,  addNewAlertActivity
     */
    public void addAlert(Alert newAlert, AddNewAlertActivity addNewAlertActivity) {
        File path =  addNewAlertActivity.getApplicationContext().getFilesDir();
        String fileName = "alerts.csv";
        try{
            FileOutputStream writer = new FileOutputStream( new File(path, fileName));
            String data = getDate() + "," + getTime() + "," + getSender() + "," + getMessage();
            writer.write(data.getBytes());
            writer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * READS in alerts.csv,
     * reads line by line searching for a matching date and time
     * and returns the alert
     *
     * Format of alerts.csv:
     * date,time,sender,message
     *
     * @return
     */
    public Alert getAlert(String date, String time, AddNewAlertActivity addNewAlertActivity){
        File path =  addNewAlertActivity.getApplicationContext().getFilesDir();
        String fileName = "alerts.csv";
        File readFrom = new File(path, fileName);
        Alert alert = null;

        try{
            Scanner scnr = new Scanner(readFrom);
            while(scnr.hasNext()){
                String line = "";
                line = scnr.nextLine();
                String data[] = line.split(",");
                if(data[0] == date && data[1] == time){
                    alert = new Alert(data[0], data[1], data[2], data[3]);
                    return alert;
                }

            }
            scnr.close();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;

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

    public String toString(){
        String s = "";
        s += "Date: " + getDate() + "\n";
        s += "Time: " + getTime() + "\n";
        s += "Sender: " + getSender() + "\n";
        s += "Message: " + getMessage() + "\n";

        return s;
    }
}
