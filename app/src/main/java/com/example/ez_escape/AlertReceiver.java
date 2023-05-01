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

public class AlertReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notificationHelper = new NotificationHelper(context);
        System.out.println("Inside of onReceive()");
        String data = intent.getStringExtra("data");
        System.out.println(data);

        //NotificationCompat.Builder nb = notificationHelper.getChannelNotification(data);

        String arr[] = data.split(",");
        String sender = arr[0];
        String message = arr[1];
/*
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "ChannelID")
                .setContentTitle(sender)
                .setContentText(message)
                .setSmallIcon(R.drawable.messageicon);

        notificationHelper.getManager().notify(1, builder.build());
*/
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), "notify_001").setContentTitle(sender).setContentText(message).setSmallIcon(R.drawable.messageicon);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String channelId = "notify_001";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_HIGH);
            mNotificationManager.createNotificationChannel(channel);
            mBuilder.setChannelId(channelId);
        }

        mNotificationManager.notify(0, mBuilder.build());

    }
}
//This is for making the notifications that are received from the alert manager