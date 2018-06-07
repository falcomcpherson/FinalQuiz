package com.example.android.finalquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Question5Splash extends AppCompatActivity {

    ImageButton questionFiveButton;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionFiveButton = findViewById(R.id.questionFiveButton);

        questionFiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Question5Splash.this, Question5.class);
                intentLoadNewActivity.putExtra("runningScore", runningScore);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public int updateScore() {
        Intent intentQuestion4Point = getIntent();
        runningScore = intentQuestion4Point.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question5Splash.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
