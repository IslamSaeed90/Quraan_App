package com.islamsaeed.quran;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startSurasActivity();
            }

        }, 2000);

    }

    public void startSurasActivity() {
        Intent intent = new Intent(Splash.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


}