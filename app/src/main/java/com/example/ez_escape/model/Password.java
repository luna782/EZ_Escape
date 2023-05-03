package com.example.ez_escape.model;


import com.example.ez_escape.AddNewAlertActivity;
import com.example.ez_escape.MainActivity;
import com.example.ez_escape.SettingsActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * The user's password is stored in the internal storage of the phone in a file called password.csv
 * password.csv should only contain one line of data being the user's password
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class Password {



    // for when a password needs to be read in MainActivity or read/written in SettingsActivity

    /**
     * addNewPassword() writes the passed in new password to passwords.csv
     * @param settingsActivity
     * @param newPassword
     */
    public void addNewPassword(SettingsActivity settingsActivity, String newPassword) {
        String fileName = "password.csv";
        File file = new File(settingsActivity.getFilesDir(), fileName);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(newPassword);
            osw.flush();
            osw.close();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * addNewPassword() writes the passed in new password to passwords.csv
     * @param mainActivity
     * @param newPassword
     */
    public void addNewPassword(MainActivity mainActivity, String newPassword) {
        String fileName = "password.csv";
        File file = new File(mainActivity.getFilesDir(), fileName);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(newPassword);
            osw.flush();
            osw.close();
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * readUserPassword returns the user's password as a string
     * if null is returned, a password has not been set
     * @param settingsActivity
     * @return
     * @throws IOException
     */
    public String readUserPassword(SettingsActivity settingsActivity) throws IOException {
        String fileName = "password.csv";

        Alert alert = null;
        File file = new File(settingsActivity.getFilesDir(), fileName);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;


        try{
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            String password = "";
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null ){
                sb.append(line);
                password = line;
            }
            br.close();
            isr.close();
            fis.close();
            return password;
        }
        catch (Exception e){
            e.printStackTrace();
            this.addNewPassword(settingsActivity, "");
            return "";
        }

    }

    /**
     * readUserPassword returns the user's password as a string
     * if null is returned, a password has not been set
     * @param mainActivity
     * @return
     * @throws IOException
     */
    public String readUserPassword(MainActivity mainActivity) throws IOException {
        String fileName = "password.csv";

        Alert alert = null;
        File file = new File(mainActivity.getFilesDir(), fileName);
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            String password = "";
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null ){
                sb.append(line);
                password = line;
            }
            br.close();
            isr.close();
            fis.close();
            return password;
        }
        catch (Exception e){
            e.printStackTrace();
            this.addNewPassword(mainActivity, "");
            return "";
        }

    }

}
