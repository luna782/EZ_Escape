package com.example.ez_escape;

import static com.example.ez_escape.model.GlobalAlarmData.getGlobalAlarmData;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.controller.CalendarController;
import com.example.ez_escape.controller.NewAlertController;
import com.example.ez_escape.controller.ClearController;
import com.example.ez_escape.controller.SaveController;
import com.example.ez_escape.controller.SettingsController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * This activity allows the user to add a new alert to the list of existing alerts
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class AddNewAlertActivity extends AppCompatActivity {

    //private String userInputDate;
    //private String userInput;
    //EditText dateInputButton;
    private static int requestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alert);

        //Pass to alert receiver
        AlertReceiver.setNewAlertActivity(this);

        //create alarm manager
        AlarmManager alarmManager;

        Button clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener( new ClearController(this) );

        Button save_button = findViewById(R.id.save_button);
        save_button.setOnClickListener(new SaveController(this));

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

        try {
            requestCode = readAlarmCode(this);
        } catch (IOException e) {
            requestCode = 1;
            throw new RuntimeException(e);
        }
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
    public void startAlarm(long alarmMillis){
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);

        //most recent alarm data would be in the last index of the data ArrayList
        int lastIndex = getGlobalAlarmData().getData().size() - 1;
        String data = getGlobalAlarmData().getData().get(lastIndex);
        intent.putExtra("data", data);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, alarmMillis, pendingIntent);

        AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(alarmMillis, pendingIntent);
        alarmManager.setAlarmClock(alarmClockInfo, pendingIntent);

        requestCode++;
        updateAlarmCode(this, requestCode);
    }

    public void updateAlarmCode(AddNewAlertActivity newAlertactivity, int requestCode) {
        String fileName = "alarmCode.csv";
        File file = new File(newAlertactivity.getFilesDir(), fileName);
        String code = String.valueOf(requestCode);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(code);
            osw.flush();
            osw.close();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public int readAlarmCode(AddNewAlertActivity newAlertactivity) throws IOException {
        String fileName = "alarmCode.csv";

//        File readFrom = new File(path, fileName);
        File file = null;
        try {
            file = new File(newAlertactivity.getFilesDir(), fileName);
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.updateAlarmCode(this, 1);
            return 1;
        }

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;


        try{
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            int code = 1;
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null ){
                sb.append(line);
                code = Integer.parseInt(line);
            }
            br.close();
            isr.close();
            fis.close();
            return code;
        }
        catch (Exception e){
            e.printStackTrace();
            this.updateAlarmCode(this, 1);
            return 1;
        }

    }

}