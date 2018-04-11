package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Question4 extends AppCompatActivity {

    Button questionFourSubmitButton;
    int runningScore;
    String darryl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        updateScore();

        questionFourSubmitButton = findViewById(R.id.questionFourSubmitButton);
        questionFourSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et = (EditText) findViewById(R.id.darryl);
                darryl = et.getText().toString().toUpperCase();
                if (darryl .equals("DARRYL")){
                    runningScore = runningScore + 1;
                }

                Intent intentQuestion4Point = new Intent(Question4.this, Question5Splash.class);
                intentQuestion4Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion4Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;
    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question4.this, MainActivity.class);
        startActivity(intentReturnHome);
    }

}
