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

public class Question9 extends AppCompatActivity {

    Button questionNineSubmitButton;
    RadioButton natalieRushman;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionNineSubmitButton = findViewById(R.id.questionNineSubmitButton);
        questionNineSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                natalieRushman = (RadioButton) findViewById(R.id.natalieRushman);
                natalieRushman.isChecked();
                if (natalieRushman.isChecked()) {
                    runningScore = runningScore + 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "Oh Natalie, we knew you looked familiar!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "Looks like Ms. Rushman will be getting the drop on you!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
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
