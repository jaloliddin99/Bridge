package com.jaloliddinabdullaevv.bridge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

public class TestActivity extends AppCompatActivity {
    MaterialCardView firstStep, secondStep, thirdStep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        getSupportActionBar().setTitle("Savol & Test");
        firstStep=findViewById(R.id.firstStep);
        secondStep=findViewById(R.id.secondStep);
        thirdStep=findViewById(R.id.thirdStep);

        firstStep.setTranslationX(-1100);
        firstStep.animate().translationXBy(1100).setDuration(1000);
        secondStep.setTranslationX(1100);
        secondStep.animate().translationXBy(-1100).setDuration(1000);
        thirdStep.setTranslationX(-1100);
        thirdStep.animate().translationXBy(1100).setDuration(1000);

        firstStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), QuizActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        secondStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}