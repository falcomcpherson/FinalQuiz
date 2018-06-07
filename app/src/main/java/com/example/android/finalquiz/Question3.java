package com.example.android.finalquiz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    Button questionThreeSubmitButton;
    RadioButton soulStone;
    int runningScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionThreeSubmitButton = findViewById(R.id.questionThreeSubmitButton);
        questionThreeSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                soulStone = (RadioButton) findViewById(R.id.soulStone);
                soulStone.isChecked();
                if (soulStone.isChecked()) {
                    runningScore = runningScore + 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "That's the one!\rNow where did I leave that thing?";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                }else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "The correct answer was Soul Stone...\rBright.. Orange... MISSING!!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }

                Intent intentQuestion3Point = new Intent(Question3.this, Question4Splash.class);
                intentQuestion3Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion3Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question3.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
