package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Question2 extends AppCompatActivity {

    Button questionTwoSubmitButton;
    int runningScore;
    CheckBox jarvis;
    CheckBox friday;
    CheckBox jeff;
    CheckBox skywalker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        updateScore();

        questionTwoSubmitButton = findViewById(R.id.questionTwoSubmitButton);
        questionTwoSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jarvis = (CheckBox) findViewById(R.id.jarvis);
                jarvis.isChecked();
                if (jarvis.isChecked()) {
                    friday = (CheckBox) findViewById(R.id.friday);
                    friday.isChecked();
                    if (jarvis.isChecked()) {
                        jeff = (CheckBox) findViewById(R.id.jeff);
                        jeff.isChecked();
                        if (jeff.isChecked()) {
                            runningScore = runningScore;
                        } else {
                            skywalker = (CheckBox) findViewById(R.id.skywalker);
                            skywalker.isChecked();
                            if (skywalker.isChecked()) {
                                runningScore = runningScore;
                            } else {
                                runningScore = runningScore + 1;
                            }
                        }
                    }
                }

                Intent intentQuestion2Point = new Intent(Question2.this, Question3Splash.class);
                intentQuestion2Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion2Point);
            }
        });
    }

    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question2.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
