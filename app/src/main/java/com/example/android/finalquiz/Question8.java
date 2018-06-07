package com.example.android.finalquiz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question8 extends AppCompatActivity {

    Button questionEightSubmitButton;
    int runningScore;
    CheckBox jarvis;
    CheckBox lightning;
    CheckBox infinityStone;
    CheckBox nuclearReactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        updateScore();

        questionEightSubmitButton = findViewById(R.id.questionEightSubmitButton);
        questionEightSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jarvis = (CheckBox) findViewById(R.id.jarvis);
                jarvis.isChecked();
                if (jarvis.isChecked()) {
                    lightning = (CheckBox) findViewById(R.id.lightning);
                    lightning.isChecked();
                    if (lightning.isChecked()) {
                        infinityStone = (CheckBox) findViewById(R.id.infinityStone);
                        infinityStone.isChecked();
                        if (infinityStone.isChecked()) {
                            nuclearReactor = (CheckBox) findViewById(R.id.nuclearReactor);
                            nuclearReactor.isChecked();
                            if (nuclearReactor.isChecked()) {
                                runningScore = runningScore;
                                Context wrong = getApplicationContext();
                                CharSequence text = "Computer says no... \rWe were looking for Jarvis, Lightning, and the Inifinity Stone";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(wrong, text, duration);
                                toast.show();
                            } else {
                                runningScore = runningScore + 1;
                                Context correct = getApplicationContext();
                                CharSequence text = "And that's how you make-a-Vision!";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(correct, text, duration);
                                toast.show();
                            }
                        }else {
                            Context wrong = getApplicationContext();
                            CharSequence text = "Computer says no...\nWe were looking for Jarvis, Lightning, and the Inifinity Stone";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(wrong, text, duration);
                            toast.show();
                        }
                    }else {
                        Context wrong = getApplicationContext();
                        CharSequence text = "Computer says no...\nWe were looking for Jarvis, Lightning, and the Inifinity Stone";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(wrong, text, duration);
                        toast.show();
                    }
                }else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "Computer says no...\nWe were looking for Jarvis, Lightning, and the Inifinity Stone";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }
                Intent intentQuestion8Point = new Intent(Question8.this, Question9Splash.class);
                intentQuestion8Point.putExtra("runningScore", runningScore);
                startActivity(intentQuestion8Point);
            }
        });
    }
    public int updateScore() {
        Intent intentLoadNewActivity = getIntent();
        runningScore = intentLoadNewActivity.getIntExtra("runningScore", 0);
        return runningScore;

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question8.this, MainActivity.class);
        startActivity(intentReturnHome);
    }
}
