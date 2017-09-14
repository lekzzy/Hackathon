package com.example.aderelemaryidowu.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by ADERELE MARY IDOWU on 6/7/2017.
 */

public class EnglishPage extends AppCompatActivity {
    RadioGroup radioG1;
    RadioGroup radioG2;
    RadioGroup radioG3;
    RadioGroup radioG4;
    RadioGroup radioG5;
    CountDownTimer countDownTimer;
    int score = 0;
    long timer1;
    String name;


    boolean timerHasStarted = false;
    TextView text1;
    TextView text2;
    long startTime = 300 * 1000;
    long interval = 1 * 1000;
    String FORMAT = "%02d:%02d:%02d";

    public class MyCountDownTimer extends CountDownTimer
    {

        public MyCountDownTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }
        @Override
        public void onFinish()
        {
            text1.setText("Time's up!");
        }

        @Override

        public void onTick(long millisUntilFinished)
        {
            timer1 = millisUntilFinished;
            text1.setText(""+String.format(FORMAT,
                    TimeUnit.MILLISECONDS.toHours(timer1),
                    TimeUnit.MILLISECONDS.toMinutes(timer1) - TimeUnit.HOURS.toMinutes
                            (TimeUnit.MILLISECONDS.toHours(timer1)),
                    TimeUnit.MILLISECONDS.toSeconds(timer1) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(timer1))));

        }

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.english);
        radioG1 = (RadioGroup)findViewById(R.id.RadioGroup1);
        radioG2 = (RadioGroup)findViewById(R.id.RadioGroup2);
        radioG3 = (RadioGroup)findViewById(R.id.RadioGroup3);
        radioG4 = (RadioGroup)findViewById(R.id.RadioGroup4);
        radioG5 = (RadioGroup)findViewById(R.id.RadioGroup5);
        text1 = (TextView)findViewById(R.id.timer_one);
        text2 = (TextView)findViewById(R.id.welcome_id);

        countDownTimer = new EnglishPage.MyCountDownTimer(startTime, interval);
        text1.setText(text1.getText() + String.valueOf(startTime / 1000));

        if (!timerHasStarted)
        {
            countDownTimer.start();
            timerHasStarted = true;
            text1.setText("STOP");
        }
        else
        {
            countDownTimer.cancel();
            timerHasStarted = false;
            text1.setText("RESTART");
        }



        name = getIntent().getStringExtra("nameText");
        text2.setText("Welcome " + name);
    }


    public void submit (View view)
    {
        if(radioG1.getCheckedRadioButtonId() == R.id.option_4)
        {
            score = score + 1;
        }
        else
        {
            score = score + 0;
        }
        if(radioG2.getCheckedRadioButtonId()== R.id.option_b)
        {
            score = score + 1;
        }
        else
        {
            score = score + 0;
        }

        if(radioG3.getCheckedRadioButtonId()== R.id.option_a3)
        {
            score = score + 1;
        }
        else
        {
            score = score + 0;
        }
        if(radioG4.getCheckedRadioButtonId()== R.id.option_a4){
            score = score + 1;
        }
        else
        {
            score = score + 0;
        }
        if(radioG5.getCheckedRadioButtonId()== R.id.option_c5)
        {
            score = score + 1;
        }
        else
        {
            score = score + 0;
        }

        Intent intent = new Intent(this, ResultPage.class);
        intent.putExtra("result", score);
        intent.putExtra("nameEntered", name);
        startActivity(intent);
    }


}
