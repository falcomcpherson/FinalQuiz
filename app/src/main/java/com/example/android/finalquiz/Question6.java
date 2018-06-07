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

public class Question6 extends AppCompatActivity {

    Button questionSixSubmitButton;
    int runningScore;
    String nickFury;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionSixSubmitButton = findViewById(R.id.questionSixSubmitButton);
        questionSixSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et = (EditText) findViewById(R.id.nickFury);
                nickFury = et.getText().toString().toUpperCase();
                if (nickFury .equals("NICK FURY")){
                    runningScore = runningScore + 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "Fury's got his eye on you!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "I bet you're Nick-Furious you got that wrong!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }

                Intent intentQuestion6Point = new Intent(Question6.this, Question7Splash.class);
                intentQuestion6Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion6Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;
    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question6.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}