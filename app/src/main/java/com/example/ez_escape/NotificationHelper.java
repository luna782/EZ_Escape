package com.example.ez_escape;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";

    private NotificationManager tManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChannel();
    }
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
        getManager().createNotificationChannel(channel);
    }
    public NotificationManager getManager(){
        if (tManager == null)
            tManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return tManager;
    }

    public NotificationCompat.Builder getChannelNotification(String data) {
        System.out.println("Inside of getChannelNotification()");
        String arr[] = data.split(",");
        String sender = arr[0];
        String message = arr[1];
        System.out.println(sender + "/" + message);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelID)
                .setSmallIcon(R.drawable.messageicon)
                .setContentTitle(sender)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder;
    }
}

