package com.jaloliddinabdullaevv.bridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.jaloliddinabdullaevv.bridge.Adapter.AnswerSheetAdapter;
import com.jaloliddinabdullaevv.bridge.Adapter.ResultAdapter;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.QuestionNumber;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ResultActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @SuppressLint("StaticFieldLeak")
    public static TextView correctAnswer, time_taken;
    ArrayList<QuestionNumber> arraylist;
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.magenta));

        Common.currentQuestion =0;
        recyclerView=findViewById(R.id.recycler_togri_javoblar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        time_taken=findViewById(R.id.time_taken);
        correctAnswer=findViewById(R.id.togriJavob);
        time_taken.setText("Bajarilgan vaqt " +String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(Common.timer),
                TimeUnit.MILLISECONDS.toSeconds(Common.timer)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(Common.timer))));

        //Get Screen Height


        Bundle bundle = getIntent().getExtras();
        arraylist = bundle.getParcelableArrayList("mylist");
        ResultAdapter categoryAdapter =
                new ResultAdapter(ResultActivity.this, arraylist);

        recyclerView.setAdapter(categoryAdapter);

        for (int i=0; i< arraylist.size(); i++){
            if (Common.chosenAnswers.get(i).equals(Common.correctAnswersFromDb.get(i)))
                Common.correctAnswer++;
        }

        correctAnswer.setText("To'g'ri javob "+Common.correctAnswer +"ta");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        for (int i=0; i<arraylist.size() ; i++){
            AnswerSheetAdapter.colors.set(i, Color.parseColor("#34ebb4"));
        }
        Common.chosenOnlineDBAnswers.clear();
        Common.onlineDCorrectAnswers.clear();

        Common.questionNumbers.clear();

        Common.correctAnswer =0;

        Intent intent=new Intent(ResultActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();


    }
}