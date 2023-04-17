package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.ez_escape.controller.Screen2ClearController;

public class AddNewAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alert);

        Button clear_button = findViewById(R.id.clear_button);
        clear_button.setOnClickListener( new Screen2ClearController() );
    }
}