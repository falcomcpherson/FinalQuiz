package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question5 extends AppCompatActivity {

    Button questionFiveSubmitButton;
    RadioButton danceOff;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        updateScore();

        questionFiveSubmitButton = findViewById(R.id.questionFiveSubmitButton);
        questionFiveSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                danceOff = (RadioButton) findViewById(R.id.danceOff);
                danceOff.isChecked();
                if (danceOff.isChecked()) {
                    runningScore = runningScore + 1;
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
