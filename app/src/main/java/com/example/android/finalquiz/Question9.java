package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question9 extends AppCompatActivity {

    Button questionNineSubmitButton;
    RadioButton natalieRushman;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
        updateScore();

        questionNineSubmitButton = findViewById(R.id.questionNineSubmitButton);
        questionNineSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                natalieRushman = (RadioButton) findViewById(R.id.natalieRushman);
                natalieRushman.isChecked();
                if (natalieRushman.isChecked()) {
                    runningScore = runningScore + 1;
                }

                Intent intentQuestion9Point = new Intent(Question9.this, Question10Splash.class);
                intentQuestion9Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion9Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question9.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
