package com.example.android.finalquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Question10Splash extends AppCompatActivity {

    ImageButton questionTenButton;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionTenButton = findViewById(R.id.questionTenButton);

        questionTenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Question10Splash.this, Question10.class);
                intentLoadNewActivity.putExtra("runningScore", runningScore);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public int updateScore() {
        Intent intentQuestion7Point = getIntent();
        runningScore = intentQuestion7Point.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question10Splash.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
