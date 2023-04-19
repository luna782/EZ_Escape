package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.controller.MainActivityController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText passwordInputButton;
    private String userPasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the input that the
        passwordInputButton = findViewById(R.id.editTextTextPassword);


        //read from the password file
        AssetManager am = getAssets();
        String password = "";
        try {
            InputStream inStream = am.open("password.txt");
            Scanner scnr = new Scanner(inStream);
            password = scnr.nextLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Button screen1Login = findViewById(R.id.enterButton);
        screen1Login.setOnClickListener( new MainActivityController(password, this) );

    }

    public String getUserPasswordInput(){
        userPasswordInput = String.valueOf(passwordInputButton.getText());
        return this.userPasswordInput;
    }
}