package com.example.aderelemaryidowu.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void proceed (View view)
    {
        Intent intent = new Intent (this, UserDetailsPage.class);
        startActivity(intent);
    }

}
