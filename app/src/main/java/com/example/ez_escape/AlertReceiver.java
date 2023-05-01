package com.example.ez_escape;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        System.out.println("Inside of onReceive()");
        String data = intent.getStringExtra("data");

        NotificationCompat.Builder nb = notificationHelper.getChannelNotification(data);
        notificationHelper.getManager().notify(1, nb.build());

    }
}
//This is for making the notifications that are received from the alert manager