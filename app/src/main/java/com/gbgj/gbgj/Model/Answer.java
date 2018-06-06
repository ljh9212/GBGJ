package com.gbgj.gbgj.Model;

public class Answer{
    String text;
    boolean isRightChoice = false;

    public Answer() {
    }

    public Answer(String text, boolean isRightChoice) {
        this.text = text;
        this.isRightChoice = isRightChoice;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRightChoice() {
        return isRightChoice;
    }

    public void setRightChoice(boolean rightChoice) {
        isRightChoice = rightChoice;
    }
}
