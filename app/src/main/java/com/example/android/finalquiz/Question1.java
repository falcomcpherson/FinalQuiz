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

public class Question1 extends AppCompatActivity {

    Button questionOneSubmitButton;
    int runningScore = 0;
    RadioButton chimichangas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        questionOneSubmitButton = findViewById(R.id.questionOneSubmitButton);
        questionOneSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chimichangas = (RadioButton) findViewById(R.id.chimichangas);
                chimichangas.isChecked();
                if(chimichangas.isChecked()) {
                    runningScore = 1;
                    Context correct = getApplicationContext();
                    CharSequence text = "You're absolutely right!!!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(correct, text, duration);
                    toast.show();
                } else {
                    Context wrong = getApplicationContext();
                    CharSequence text = "The correct answer was Chimichangas...\rWhich would've been delicios!!!!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(wrong, text, duration);
                    toast.show();
                }
                Intent intentQuestion1Point = new Intent(Question1.this,Question2Splash.class);
                intentQuestion1Point.putExtra("runningScore",runningScore);
                startActivity(intentQuestion1Point);


            }
        });

    }
    public void onBackPressed() {
        Intent intentReturnHome = new Intent(Question1.this, MainActivity.class);
        startActivity(intentReturnHome);
    }


}
