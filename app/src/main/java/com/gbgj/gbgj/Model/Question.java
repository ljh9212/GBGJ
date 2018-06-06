package com.gbgj.gbgj.Model;

import java.util.ArrayList;

public class Question {

    int mQuestionId;
    String mQuestioContent = "";
    ArrayList<Answer> mQuestioAnswer = new ArrayList<>();

    public Question() {
    }

    public Question(int mQuestionId, String mQuestioContent, ArrayList<Answer> mQuestioAnswer) {
        this.mQuestionId = mQuestionId;
        this.mQuestioContent = mQuestioContent;
        this.mQuestioAnswer = mQuestioAnswer;
    }

    public int getmQuestionId() {
        return mQuestionId;
    }

    public void setmQuestionId(int mQuestionId) {
        this.mQuestionId = mQuestionId;
    }

    public String getmQuestioContent() {
        return mQuestioContent;
    }

    public void setmQuestioContent(String mQuestioContent) {
        this.mQuestioContent = mQuestioContent;
    }

    public ArrayList<Answer> getmQuestioAnswer() {
        return mQuestioAnswer;
    }

    public void setmQuestioAnswer(ArrayList<Answer> mQuestioAnswer) {
        this.mQuestioAnswer = mQuestioAnswer;
    }
}
