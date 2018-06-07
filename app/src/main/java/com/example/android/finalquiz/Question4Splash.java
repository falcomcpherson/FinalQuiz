package com.example.android.finalquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Question4Splash extends AppCompatActivity {

    ImageButton questionFourButton;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4_splash);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionFourButton = findViewById(R.id.questionFourButton);

        questionFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Question4Splash.this, Question4.class);
                intentLoadNewActivity.putExtra("runningScore", runningScore);
                startActivity(intentLoadNewActivity);
            }
        });
    }
    public int updateScore() {
        Intent intentQuestion3Point = getIntent();
        runningScore = intentQuestion3Point.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question4Splash.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
