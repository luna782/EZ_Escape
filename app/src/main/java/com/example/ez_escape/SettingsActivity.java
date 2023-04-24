package com.example.ez_escape;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ez_escape.controller.SettingsController;
import com.example.ez_escape.controller.SettingsSubmitNewPassword;
import com.example.ez_escape.model.Password;

import java.io.IOException;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Password passwordInstance = new Password();
        TextView currPassword = findViewById(R.id.current_password);
        String userPass = "";
        try {
            userPass = passwordInstance.readUserPassword(this);
            currPassword.setText( userPass );
        } catch (IOException e) {
            System.out.println("Settings Activity could not read what the user's password is");
            if(userPass == null || userPass.equals("")){
                System.out.println("User password read in Settings Activity is null");
            }
            throw new RuntimeException(e);
        }
        Button submitNewPasswordButton = findViewById(R.id.submit_new_password);
        submitNewPasswordButton.setOnClickListener( new SettingsSubmitNewPassword(this) );

    }
}