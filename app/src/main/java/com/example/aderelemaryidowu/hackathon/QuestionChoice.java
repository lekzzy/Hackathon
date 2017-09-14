package com.example.aderelemaryidowu.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ADERELE MARY IDOWU on 6/17/2017.
 */

public class QuestionChoice extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    int total;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_page);

        textView1 = (TextView) findViewById(R.id.result_field1);
        textView2 = (TextView) findViewById(R.id.result_field2);

        name = getIntent().getStringExtra("name");
        String valuePhoneNumber = getIntent().getStringExtra("PhoneNumber");
        String valueBirthYear = getIntent().getStringExtra("BirthYear");

        String valueYear = Character.toString(valueBirthYear.charAt(3));
        String valuePhone1 = Character.toString(valuePhoneNumber.charAt(9));
        String valuePhone2 = Character.toString(valuePhoneNumber.charAt(10));
        String actualPhoneValue = valuePhone1 + valuePhone2;

       int phoneValueToInt = Integer.parseInt(actualPhoneValue);
       int birthYearToInt = Integer.parseInt(valueYear);

        total = phoneValueToInt + birthYearToInt;
        textView1.setText(name + " The addition of the last two digits of your phone number and the last digit of your year of birth is");

        if (total % 2 == 0) {

            textView2.setText("" + total + " is even: Your question is Mathematics");
        }
        else {
            textView2.setText("" + total + " is odd: Your question is English");
        }
    }

    public void start(View view)
    {
        if (total % 2 == 0) {

            Intent intent = new Intent(this, MathematicsPage.class);
            intent.putExtra("nameText", name);
            startActivity(intent);
        }

        else
        {
            Intent intent = new Intent(this, EnglishPage.class);
            intent.putExtra("nameText", name);
            startActivity(intent);
        }
    }
}