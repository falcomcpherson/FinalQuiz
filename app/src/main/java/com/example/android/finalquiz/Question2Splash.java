package com.example.android.finalquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Question2Splash extends AppCompatActivity {

    ImageButton questionTwoButton;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionTwoButton = findViewById(R.id.questionTwoButton);

        questionTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Question2Splash.this, Question2.class);
                intentLoadNewActivity.putExtra("runningScore", runningScore);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public int updateScore() {
        Intent intentQuestion1Point = getIntent();
        runningScore = intentQuestion1Point.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question2Splash.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
