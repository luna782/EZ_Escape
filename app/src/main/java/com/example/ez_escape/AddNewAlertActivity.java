package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.ez_escape.controller.Screen2ClearController;
import com.example.ez_escape.model.Alert;

import java.io.IOException;

public class AddNewAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alert);

        Button clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener( new Screen2ClearController(this) );

        //testing writing and reading the alerts
        String date = "05/2314";
        String time = "01:22:1";
        Alert newAlert = new Alert(date, time, "dude", "bob");
        newAlert.addAlert(this);
        Alert ret = null;
        try {
            ret = newAlert.getAlert(date, time, this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ret);
        System.out.println("Ramin Test\n");


    }
}