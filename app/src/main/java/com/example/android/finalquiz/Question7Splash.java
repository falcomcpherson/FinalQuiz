package com.example.android.finalquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Question7Splash extends AppCompatActivity {

    ImageButton questionSevenButton;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionSevenButton = findViewById(R.id.questionSevenButton);

        questionSevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Question7Splash.this, Question7.class);
                intentLoadNewActivity.putExtra("runningScore", runningScore);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public int updateScore() {
        Intent intentQuestion6Point = getIntent();
        runningScore = intentQuestion6Point.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question7Splash.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
