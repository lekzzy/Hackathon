package com.example.aderelemaryidowu.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ADERELE MARY IDOWU on 6/7/2017.
 */

public class ResultPage extends AppCompatActivity {
    TextView textview;
    int score = 0;

    public void onBackPressed() {
        score = 0;
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);

        score = getIntent().getIntExtra("result", 0);
        String name1 = getIntent().getStringExtra("nameEntered");
        textview = (TextView) findViewById(R.id.result_text);
        if(score < 2) {
            textview.setText("Oops!!! " + name1 + " you scored " + score + " out of 5");
        }
        if(score >= 3) {
            textview.setText("Congratulations " + name1 + " you scored " + score + " out of 5");
        }
        if(score == 5) {
            textview.setText("Awesome " + name1 + " you scored " + score + " out of 5");
        }
    }
    public void share (View view)
    {
        String message = "Hello friend, I scored " + score + " from QuizApp";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(share, "QuizApp"));
    }

}