package com.gbgj.gbgj.Model;

import java.util.ArrayList;

public class QuestionBank {
    int mQuestionIndex = 0;
    ArrayList<Question> mQuestionList = new ArrayList<>();

    public ArrayList<Question> getmQuestionList() {
        return mQuestionList;
    }

    public void setmQuestionList(ArrayList<Question> mQuestionList) {
        this.mQuestionList = mQuestionList;
    }

    public void addmQuestion(Question mQuestion) {
        this.mQuestionList.add(mQuestion);
    }

    public Question getNextQuestion(){
        mQuestionIndex++;

        if(mQuestionIndex >= mQuestionList.size()){
            mQuestionIndex = 0;
        }

        Question question = mQuestionList.get(mQuestionIndex);

        return question;
    }

    public Question getPrevQuestion(){
        mQuestionIndex--;

        if(mQuestionIndex < 0){
            mQuestionIndex = mQuestionList.size() - 1;
        }

        Question question = mQuestionList.get(mQuestionIndex);

        return question;
    }
}
