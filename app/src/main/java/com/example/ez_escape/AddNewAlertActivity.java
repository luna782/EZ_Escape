package com.example.ez_escape;

import static android.app.PendingIntent.FLAG_IMMUTABLE;
import static androidx.core.content.ContextCompat.getSystemService;

import static com.example.ez_escape.model.GlobalAlarmData.getGlobalAlarmData;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.controller.CalendarController;
import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.Screen2ClearController;
import com.example.ez_escape.controller.Screen2SaveController;
import com.example.ez_escape.controller.SettingsController;
import com.example.ez_escape.model.Alert;

import java.io.IOException;

public class AddNewAlertActivity extends AppCompatActivity {

    //private String userInputDate;
    //private String userInput;
    //EditText dateInputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alert);


        //create alarm manager
        AlarmManager alarmManager;

        Button clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener( new Screen2ClearController(this) );

        Button save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(new Screen2SaveController(this));

        EditText dateInputButton = findViewById(R.id.editTextDate);

        //Button that sends user to newAlertActivity Screen
        Button newAlert = findViewById(R.id.new_alert_button);
        newAlert.setOnClickListener(new NewAlertController(this) );

        //Button that sends user to Settings Screen
        Button settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new SettingsController(this) );

        //Button that sends user to Calendar Screen
        Button calendar_button = findViewById(R.id.view_scheduele_button);
        calendar_button.setOnClickListener(new CalendarController(this) );



        //testing writing and reading the alerts
        //first test
/*        String date = "05/2314";
//        String time = "01:22:1";
//        Alert newAlert = new Alert(date, time, "dude", "bob");
//        newAlert.addAlert(this);
//        Alert ret = null;
//        try {
//            ret = newAlert.getAlert(date, this);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(ret);
//        System.out.println("first alert" + ret.getDate() + ret.getMessage() );
//
//        //second test
//        Alert newAlert2 = new Alert("333", "444", "eee", "ssss");
//        newAlert2.addAlert(this);
//        try {
//            ret = newAlert.getAlert("333", this);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(ret);*/



    }

    // get the text within the button 'inputField' [when the Save button is clicked]
    // FIXME: place in Screen2SaveController ?
    public String getUserInput(EditText inputField){
        String input = String.valueOf(inputField.getText());
        return input;
    }

    // check if an input field is empty or contains only whitespace [when Save button clicked]
    // FIXME: place in Screen2SaveController ?
    public boolean isEmpty(EditText inputField) {
        String inputText = getUserInput((inputField));
        if (inputText.matches("^$") || inputText.matches("^\\s*$"))
            // note: the 'matches' method uses regex
            return true;
        else
            return false;
    }

    // check if user input is in correct format [when Save button is clicked]
    //i.e., make sure date is in format "##/##/####" and time in format "##:##"
    //call in Screen2SaveController like this:
    //   if (!isValid(date, "[0-9]{2}/[0-9]{2}/[0-9]{4}") then {show toast}
    //FIXME: place in Screen2SaveController ?
    public boolean isValid(EditText inputField, String expectedRegexPattern) {
        String inputText = getUserInput((inputField));
        if (inputText.matches(expectedRegexPattern))
            // note: the 'matches' method uses regex
            return true;
        else
            return false;
    }
    public void startAlarm(long alarmMillis, String messageContent){
        System.out.println("Inside of startAlarm");
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        /*
        //Pauls stuff
        AlertReceiver receive = new AlertReceiver();
        //Imported intent filter
        IntentFilter filter = new IntentFilter();
        registerReceiver(receive, filter);
        */
        //most recent alarm data would be in the last index of the data ArrayList
        int lastIndex = getGlobalAlarmData().getData().size() - 1;
        String data = getGlobalAlarmData().getData().get(lastIndex);
        intent.putExtra("data", messageContent);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 8, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmMillis, pendingIntent);

        AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(alarmMillis, pendingIntent);
        alarmManager.setAlarmClock(alarmClockInfo, pendingIntent);

        boolean alarmUp = (PendingIntent.getBroadcast(this, 8,
                new Intent(this, AlertReceiver.class),
                PendingIntent.FLAG_IMMUTABLE) != null);

        if (alarmUp) {
            Log.d("myTag", "Alarm is already active");
        }
    }

}