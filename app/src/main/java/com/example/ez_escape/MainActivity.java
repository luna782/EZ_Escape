package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ez_escape.controller.Screen1LoginController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText inputButton;
    private String userInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the input that the
        inputButton = findViewById(R.id.editTextTextPassword);
        userInput = String.valueOf(inputButton.getText());

        //read from the password file
        AssetManager am = getAssets();
        String password = "";
        try {
            InputStream inStream = am.open("password.txt");
            Scanner scnr = new Scanner(inStream);
            String temp = scnr.nextLine();
            if(! temp.isEmpty() ) {
                password = temp;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Button screen1Login = findViewById(R.id.enterButton);
        screen1Login.setOnClickListener( new Screen1LoginController(password, this) );

    }

    public String getUserInput(){
        return this.userInput;
    }
}