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

public class Question5 extends AppCompatActivity {

    Button questionFiveSubmitButton;
    RadioButton danceOff;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionFiveSubmitButton = findViewById(R.id.questionFiveSubmitButton);
        questionFiveSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                danceOff = (RadioButton) findViewById(R.id.danceOff);
                danceOff.isChecked();
                if (danceOff.isChecked()) {
                    runningScore = runningScore + 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "Star-Lord of the Dance is more like it!!!!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "It was a dance off!\rMaybe you should go back and check out his sweet moves";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }

                Intent intentQuestion5Point = new Intent(Question5.this, Question6Splash.class);
                intentQuestion5Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion5Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question5.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
