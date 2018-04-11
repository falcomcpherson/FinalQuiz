package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Question10 extends AppCompatActivity {

    Button questionTenSubmitButton;
    int runningScore;
    String mattDamon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);
        updateScore();

        questionTenSubmitButton = findViewById(R.id.questionTenSubmitButton);
        questionTenSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et = (EditText) findViewById(R.id.mattDamon);
                mattDamon = et.getText().toString().toUpperCase();
                if (mattDamon .equals("MATT DAMON")){
                    runningScore = runningScore + 1;
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
