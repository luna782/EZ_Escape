package com.example.ez_escape.model;

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
