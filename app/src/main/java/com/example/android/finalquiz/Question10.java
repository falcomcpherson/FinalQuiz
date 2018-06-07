package com.example.android.finalquiz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question10 extends AppCompatActivity {

    Button questionTenSubmitButton;
    int runningScore;
    String mattDamon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionTenSubmitButton = findViewById(R.id.questionTenSubmitButton);
        questionTenSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et = (EditText) findViewById(R.id.mattDamon);
                mattDamon = et.getText().toString().toUpperCase();
                if (mattDamon .equals("MATT DAMON")){
                    runningScore = runningScore + 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "MATT DAMON!! MATT DAMON!!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "It was Matt Damon... \rDid you think it was Bat-fleck or something?";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }

                Intent intentQuestion10Point = new Intent(Question10.this, FinalScore.class);
                intentQuestion10Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion10Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;
    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question10.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
