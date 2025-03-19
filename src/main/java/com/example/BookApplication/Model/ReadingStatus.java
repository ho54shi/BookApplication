package com.example.BookApplication.Model;

public enum ReadingStatus {
    UNREAD("未読"),
    READING("読書中"),
    READ("読了");

    private final String label;

    ReadingStatus(String label){
        this.label = label;
    }

    public  String getLabel(){
        return label;
    }
}
