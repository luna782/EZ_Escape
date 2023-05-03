package com.example.ez_escape.model;

/**
 * This class is used to hold the data for one row in the list view of alerts for a specific date
 * The list view is displayed in the view alerts activity screen
 *
 * UTSA CS 3443 - Final Project
 *  * Spring 2023
 */
public class AlertViews {
    private String textView;

    public AlertViews(String textView){
        setTextView(textView);
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }
}
