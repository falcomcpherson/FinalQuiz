package com.example.android.finalquiz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question7 extends AppCompatActivity {

    Button questionSevenSubmitButton;
    RadioButton shield;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionSevenSubmitButton = findViewById(R.id.questionSevenSubmitButton);
        questionSevenSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shield = (RadioButton) findViewById(R.id.shield);
                shield.isChecked();
                if (shield.isChecked()) {
                    runningScore = runningScore + 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "I'm not saying I gave that one away...but...";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "Remember that picture I showed you a second ago?\rSubtle hint... regarding his Shield!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }

                Intent intentQuestion7Point = new Intent(Question7.this, Question8Splash.class);
                intentQuestion7Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion7Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question7.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
