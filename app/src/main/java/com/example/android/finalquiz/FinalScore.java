package com.example.android.finalquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScore extends AppCompatActivity {

    Button tryAgainButton;
    String finalScoreMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        displayScore(finalScoreMessage);

        tryAgainButton = findViewById(R.id.tryAgainButton);
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(FinalScore.this, MainActivity.class);
                startActivity(intentLoadNewActivity);
            }

    });}

    public void displayScore(String finalScoreMessage) {
        Intent intentQuestion10Point = getIntent();
        int runningScore = intentQuestion10Point.getIntExtra("runningScore", 0);
        if ((runningScore >= 0) && (runningScore <= 3)) {
            finalScoreMessage = ("Your final score is " + runningScore + " out of 10!\nBetter luck next time!");
        }
        if ((runningScore >= 4) && (runningScore <= 7)) {
            finalScoreMessage = ("Your final score is " + runningScore + " out of 10!\nYou did pretty good!");
        }
        if ((runningScore >= 8) && (runningScore <= 10)) {
            finalScoreMessage = ("Your final score is " + runningScore + " out of 10!\nGreat job Avenger!!");
        }
        TextView finalScoreTextView = findViewById(R.id.finalScore);
        finalScoreTextView.setText (finalScoreMessage);
    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(FinalScore.this, MainActivity.class);
        startActivity(intentReturnHome);
    }


}

