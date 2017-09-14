package com.example.aderelemaryidowu.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ADERELE MARY IDOWU on 6/17/2017.
 */

public class UserDetailsPage extends AppCompatActivity {

    EditText nameField;
    EditText phoneField;
    EditText yearField;
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);
        nameField = (EditText) findViewById(R.id.name_field);
        phoneField = (EditText) findViewById(R.id.phone_field);
        yearField = (EditText) findViewById(R.id.year_field);


    }

    public void calculate(View view) {
        String user_name = nameField.getText().toString();
        String phoneNumber = phoneField.getText().toString();
        String birthYear = yearField.getText().toString();

        Intent intent = new Intent (this, QuestionChoice.class);
        intent.putExtra("name", user_name);
        intent.putExtra("PhoneNumber", phoneNumber);
        intent.putExtra("BirthYear", birthYear);
        startActivity(intent);

    }


}