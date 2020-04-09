package com.example.mastereapp.Entities;

public class Memo {
    private String text;

    public Memo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
