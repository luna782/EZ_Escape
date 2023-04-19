package com.example.ez_escape.model;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.text.InputType;

import com.example.ez_escape.AddNewAlertActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
     */
    public void addAlert(AddNewAlertActivity addNewAlertActivity) {
//        File path =  addNewAlertActivity.getApplicationContext().getFilesDir();
        String fileName = "alerts.csv";
        File file = new File(addNewAlertActivity.getFilesDir(), fileName);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
//            FileWriter writer = new FileWriter( file )
            String data = getDate() + "," + getTime() + "," + getSender() + "," + getMessage();
//            fos.write(data.getBytes());
            osw.write(data);
            osw.flush();
            osw.close();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }

    /**
     * READS in alerts.csv,
     * reads line by line searching for a matching date (get alerts for a specific date)
     * and adds that alert to an arraylist then returns that array list after reading all lines in the file
     *
     * Format of alerts.csv:
     * date,time,sender,message
     *
     * @return
     */
    public ArrayList<Alert> getAlert(String date, AddNewAlertActivity addNewAlertActivity) throws IOException {
        String fileName = "alerts.csv";

//        File readFrom = new File(path, fileName);
        Alert alert = null;
        File file = new File(addNewAlertActivity.getFilesDir(), fileName);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        ArrayList<Alert> arrAlerts = new ArrayList<>();

        try{
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null ){
                sb.append(line);
                System.out.println("Line Read in:" + line);
                String data[] = line.split(",");
                if(data[0].equals(date)){
                    alert = new Alert(data[0], data[1], data[2], data[3]);
                    arrAlerts.add(alert);
                }
            }
            br.close();
            isr.close();
            fis.close();
            return arrAlerts;
        }
        catch (Exception e){
            e.printStackTrace();
            br.close();
            isr.close();
            fis.close();
            return null;
        }

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
