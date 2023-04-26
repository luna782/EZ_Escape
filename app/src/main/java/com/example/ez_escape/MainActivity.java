package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.controller.MainActivityController;
import com.example.ez_escape.model.Password;

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


        //Read from the password.csv file using the Password class model
        //if string returned equals null, then no password is assigned
        //otherwise, the string returned is the user's password
        Password passwordInstance = new Password();
        String password = "";

        try {
            password = passwordInstance.readUserPassword(this);
            System.out.println("This is password return value " + password);
        } catch (IOException e) {
            System.out.println("ERROR: could not read the user password");
            if(password == null){
                System.out.println("Password equals null");
            }
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