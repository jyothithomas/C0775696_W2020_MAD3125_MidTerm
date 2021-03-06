package com.example.c0775696_w2020_mad3125_midterm.Util;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.c0775696_w2020_mad3125_midterm.Activity.PersonInfoActivity;
import com.example.c0775696_w2020_mad3125_midterm.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, PersonInfoActivity.class);
                startActivity(i);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
