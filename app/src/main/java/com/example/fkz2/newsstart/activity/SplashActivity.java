package com.example.fkz2.newsstart.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fkz2.newsstart.R;
import com.example.fkz2.newsstart.global.AppConstants;
import com.example.fkz2.newsstart.utils.SpUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isFirstOPen= SpUtils.getBoolean(this, AppConstants.FIRST_OPEN);
        if (!isFirstOPen){
            startActivity(new Intent(this,WelcomeGuideActivity.class));
            finish();
            return;
        }
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHomeActivity();
            }
        },2000);
    }

    private void enterHomeActivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
