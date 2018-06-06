package com.gbgj.gbgj.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gbgj.gbgj.Adapter.AnswerAdapter;
import com.gbgj.gbgj.Model.Answer;
import com.gbgj.gbgj.Model.Question;
import com.gbgj.gbgj.Model.QuestionBank;
import com.gbgj.gbgj.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vinos.mathjaxwebview.view.MathJaxWebView;

public class LockScreenActivity extends AppCompatActivity {
    @BindView(R.id.mathVebView_lockscreen)
    MathJaxWebView mathVebView_lockscreen;
    @BindView(R.id.fab_lockscreen_question_prev)
    FloatingActionButton fab_lockscreen_question_prev;
    @BindView(R.id.fab_lockscreen_question_next)
    FloatingActionButton fab_lockscreen_question_next;
    @BindView(R.id.fab_lockscreen_call)
    FloatingActionButton fab_lockscreen_call;
    @BindView(R.id.fab_lockscreen_unlock)
    FloatingActionButton fab_lockscreen_unlock;
    @BindView(R.id.fab_lockscreen_mother)
    FloatingActionButton fab_lockscreen_mother;
    @BindView(R.id.recyclerview_lockscreen_answer)
    RecyclerView recyclerview_lockscreen_answer;

    protected AnswerAdapter mAnswerAdapter;
    protected LinearLayoutManager mLayoutManager;

    protected AnswerAdapter.onAnswerListener onAnswerListener;

    protected QuestionBank mQuestionBank = new QuestionBank();

    static public final String TAG = "LockScreenActivity";

    @OnClick(R.id.fab_lockscreen_call)
    public void onLockScreenCallClick() {
        Toast.makeText(this, "긴급전화 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    @OnClick(R.id.fab_lockscreen_unlock)
    public void onLockScreenUnlockClick() {
        Toast.makeText(this, "언락 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fab_lockscreen_mother)
    public void onLockScreenMotherClick() {
        Toast.makeText(this, "엄마찬스 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fab_lockscreen_question_prev)
    public void onLockScreenPrevQuestionClick() {
        Toast.makeText(this, "이전 문제 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();

        setQuestion(mQuestionBank.getPrevQuestion());
    }

    @OnClick(R.id.fab_lockscreen_question_next)
    public void onLockScreenNextQuestionClick() {
        Toast.makeText(this, "다음 문제 버튼이 클릭되었습니다", Toast.LENGTH_SHORT).show();

        setQuestion(mQuestionBank.getNextQuestion());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        Question question1 = new Question();
        question1.setmQuestionId(1);
        question1.setmQuestioContent("1번문제");
        ArrayList<Answer> arrayList1 = new ArrayList();
        arrayList1.add(new Answer("<p>풍선의 부피가 늘어난다.</p>", false));
        arrayList1.add(new Answer("<p>풍선 내부의 압력이 줄어든다.</p>", false));
        arrayList1.add(new Answer("<p>공기 분자의 운동이 더 활발해진다.</p>", true));
        arrayList1.add(new Answer("<p>공기 분자 사이의 거리가 멀어진다.</p>", false));
        arrayList1.add(new Answer("<p>공기 분자의 충돌 횟수가 줄어든다.</p>", false));
        question1.setmQuestioAnswer(arrayList1);

        Question question2 = new Question();
        question2.setmQuestionId(2);
        question2.setmQuestioContent("2번문제");
        ArrayList<Answer> arrayList2 = new ArrayList();
        arrayList2.add(new Answer("<p>기체는 눈에 잘 보이기 때문</p>", false));
        arrayList2.add(new Answer("<p>기체는 압력과 부피가 반비례하기 때문</p>", false));
        arrayList2.add(new Answer("<p>기체는 압력에 따라 부피가 일정하게 증가하기 때문</p>", false));
        arrayList2.add(new Answer("<p>기체는 종류에 따라 늘어나는 부피의 비율이 다르기 때문</p>", false));
        arrayList2.add(new Answer("<p>기체는 온도에 따라 일정한 비율로 부피가 증가하기 때문</p>", true));
        question2.setmQuestioAnswer(arrayList2);

        Question question3 = new Question();
        question3.setmQuestionId(3);
        question3.setmQuestioContent("3번문제");
        ArrayList<Answer> arrayList3 = new ArrayList();
        arrayList3.add(new Answer("<p>중력 방향과 반대 방향으로 작용한다.</p>", false));
        arrayList3.add(new Answer("<p>기체 분자의 운동이 빨라지면 기체의 압력이 증가한다.</p>", false));
        arrayList3.add(new Answer("<p>기체 분자가 단위 넓이에 작용하는 힘의 크기를 나타낸다.</p>", false));
        arrayList3.add(new Answer("<p>기체 분자가 용기 벽에 충돌하는 횟수가 많아지면 증가한다.</p>", false));
        arrayList3.add(new Answer("<p>기체 분자가 스스로 운동하여 용기 벽에 충돌하기 때문에 나타난다.</p>", true));
        question3.setmQuestioAnswer(arrayList3);

        mQuestionBank.addmQuestion(question1);
        mQuestionBank.addmQuestion(question2);
        mQuestionBank.addmQuestion(question3);

        setContentView(R.layout.activity_lock_screen);
        ButterKnife.bind(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerview_lockscreen_answer.setLayoutManager(mLayoutManager);

        mAnswerAdapter = new AnswerAdapter();

        onAnswerListener = new AnswerAdapter.onAnswerListener() {
            @Override
            public void onClickAnswerItem(View v, int position) {
                TextView textView = (TextView) v.findViewById(R.id.textview_adapter_answer);
                String answer = textView.getText().toString();
                Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_SHORT).show();
            }
        };

        mAnswerAdapter.setOnAnswerListener(onAnswerListener);

        recyclerview_lockscreen_answer.setAdapter(mAnswerAdapter);

        setQuestion(mQuestionBank.getNextQuestion());
    }

    void setMathViewContent(String content) {
        mathVebView_lockscreen.setText(content);
    }

    void setQuestion(Question question){
        setMathViewContent(question.getmQuestioContent());

        ArrayList<Answer> answerArrayList = question.getmQuestioAnswer();
        ArrayList<String> answerStringArrayList = new ArrayList<>();
        for(Answer answer : answerArrayList){
            answerStringArrayList.add(answer.getText());
        }

        mAnswerAdapter.setmDataSet(answerStringArrayList);
    }
}
