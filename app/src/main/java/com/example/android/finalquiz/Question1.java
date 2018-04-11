package com.example.android.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question1 extends AppCompatActivity {

    Button questionOneSubmitButton;
    int runningScore = 0;
    RadioButton chimichangas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        questionOneSubmitButton = findViewById(R.id.questionOneSubmitButton);
        questionOneSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chimichangas = (RadioButton) findViewById(R.id.chimichangas);
                chimichangas.isChecked();
                if(chimichangas.isChecked()){
                    runningScore = 1;
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
