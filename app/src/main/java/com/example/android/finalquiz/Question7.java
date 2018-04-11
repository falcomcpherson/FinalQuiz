package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question7 extends AppCompatActivity {

    Button questionSevenSubmitButton;
    RadioButton shield;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        updateScore();

        questionSevenSubmitButton = findViewById(R.id.questionSevenSubmitButton);
        questionSevenSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shield = (RadioButton) findViewById(R.id.shield);
                shield.isChecked();
                if (shield.isChecked()) {
                    runningScore = runningScore + 1;
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
