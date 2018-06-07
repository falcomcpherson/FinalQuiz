package com.example.android.finalquiz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

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
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
                    if (friday.isChecked()) {
                        jeff = (CheckBox) findViewById(R.id.jeff);
                        jeff.isChecked();
                        if (jeff.isChecked()) {
                            runningScore = runningScore;
                            Context wrong = getApplicationContext();
                            CharSequence text = "The correct answer was Jarvis and Friday.\rMaybe next time!!!";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(wrong, text, duration);
                            toast.show();
                        } else {
                            skywalker = (CheckBox) findViewById(R.id.skywalker);
                            skywalker.isChecked();
                            if (skywalker.isChecked()) {
                                runningScore = runningScore;
                                Context wrong = getApplicationContext();
                                CharSequence text = "The correct answer was Jarvis and Friday.\rMaybe next time!!!";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(wrong, text, duration);
                                toast.show();
                            } else {
                                runningScore = runningScore + 1;
                                Context correct = getApplicationContext();
                                CharSequence text = "Friday and Jarvis are cooooo-rrect!!!";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(correct, text, duration);
                                toast.show();
                            }
                        }
                    }else {
                        Context wrong = getApplicationContext();
                        CharSequence text = "The correct answer was Jarvis and Friday.\rMaybe next time!!!";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(wrong, text, duration);
                        toast.show();
                    }
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "The correct answer was Jarvis and Friday.\rMaybe next time!!!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
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
