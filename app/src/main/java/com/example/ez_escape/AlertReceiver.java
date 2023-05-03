package com.example.ez_escape;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.ez_escape.model.Alert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This activity receives the intent that is made with each alert when the alarm for the corresponding alert goes off
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class AlertReceiver extends BroadcastReceiver {
    public static int channelNumber;
    private static AddNewAlertActivity newAlertActivity;

    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        System.out.println("Inside of onReceive()");
        String data = intent.getStringExtra("data");
        System.out.println(data);

        try {
            channelNumber = readChannelNumber(newAlertActivity);
        } catch (IOException e) {
            channelNumber = 5;
            throw new RuntimeException(e);
        }

        String arr[] = data.split(",");
        String sender = arr[0];
        String message = arr[1];

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), "notify_" + Integer.toString(AlertReceiver.channelNumber)).setContentTitle(sender).setContentText(message).setSmallIcon(R.drawable.messageicon);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "notify_" + Integer.toString(AlertReceiver.channelNumber);
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        mNotificationManager.notify(AlertReceiver.channelNumber, mBuilder.build());
        AlertReceiver.channelNumber++;

        updateChannelNumber(AlertReceiver.newAlertActivity, channelNumber);

    }

    public void updateChannelNumber(AddNewAlertActivity newAlertactivity, int channelNumber) {
        String fileName = "channelNumber.csv";
        File file = new File(newAlertactivity.getFilesDir(), fileName);
        String channel = String.valueOf(channelNumber);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(channel);
            osw.flush();
            osw.close();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void setNewAlertActivity(AddNewAlertActivity newAlertActivity) {
        AlertReceiver.newAlertActivity = newAlertActivity;
    }

    public int readChannelNumber(AddNewAlertActivity newAlertactivity) throws IOException {
        String fileName = "channelNumber.csv";

        File file = null;
        try {
            file = new File(newAlertactivity.getFilesDir(), fileName);
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.updateChannelNumber(AlertReceiver.newAlertActivity, 5);
            return 5;
        }

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;


        try{
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            int code = 5;
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null ){
                sb.append(line);
                System.out.println("Line Read in:" + line);
                code = Integer.parseInt(line);
            }
            br.close();
            isr.close();
            fis.close();
            return code;
        }
        catch (Exception e){
            e.printStackTrace();
            this.updateChannelNumber(AlertReceiver.newAlertActivity, 5);
            return 5;
        }

    }


}
//This is for making the notifications that are received from the alert manager