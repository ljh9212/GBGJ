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
import android.widget.Toast;

import com.gbgj.gbgj.Adapter.AnswerAdapter;
import com.gbgj.gbgj.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import vinos.mathjaxwebview.view.MathJaxWebView;

public class LockScreenActivity extends AppCompatActivity {
    @BindView(R.id.mathVebView_lockscreen)
    MathJaxWebView mathVebView_lockscreen;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");

        setContentView(R.layout.activity_lock_screen);
        ButterKnife.bind(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerview_lockscreen_answer.setLayoutManager(mLayoutManager);

        ArrayList<String> mAnswerSet = new ArrayList<>();
        mAnswerSet.add("답1");
        mAnswerSet.add("답2");
        mAnswerSet.add("답3");
        mAnswerSet.add("답4");
        mAnswerSet.add("답5");
        mAnswerAdapter = new AnswerAdapter(mAnswerSet);

        recyclerview_lockscreen_answer.setAdapter(mAnswerAdapter);


        setMathViewContent("<p>1,  2<sup>2</sup>  , 3, 5</p>");
    }

    void setMathViewContent(String content) {
        mathVebView_lockscreen.setText(content);
    }
}
