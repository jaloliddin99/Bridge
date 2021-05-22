package com.jaloliddinabdullaevv.bridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.jaloliddinabdullaevv.bridge.Adapter.AnswerSheetAdapter;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.DBHelper.DBHelper;
import com.jaloliddinabdullaevv.bridge.Fragment.BlankFragment;
import com.jaloliddinabdullaevv.bridge.Fragment.SavollarFragmentAdapter;
import com.jaloliddinabdullaevv.bridge.Model.CurrentQuestion;
import com.jaloliddinabdullaevv.bridge.Model.QuestionNumber;

import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity {
    ViewPager viewPager;
    RecyclerView answer_sheet_view;
    AnswerSheetAdapter answerSheetAdapter;
    TabLayout tabLayout;
    QuestionNumber questionNumber;
    int time_lay= Common.TOTAL_TIME_QUIZ;
    TextView txt_question_right, txt_timer;
    Button resultButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.magenta));

        viewPager = findViewById(R.id.viewPager);
        txt_question_right = findViewById(R.id.txt_question_right);
        txt_timer = findViewById(R.id.txt_timer);
        tabLayout = findViewById(R.id.sliding_tabs);
        resultButton = findViewById(R.id.resultButton);

        Common.questionNumbers.clear();
        Common.questionNumbers = DBHelper.getInstance(this).getQuestion();

        Common.currentQuestions.clear();
        for (int i = 0; i<Common.questionNumbers.size(); i++){
            Common.currentQuestions.add(new CurrentQuestion(i));
        }

        txt_question_right.setText((1) + "/" + (Common.questionNumbers.size()));
        timer();
        setupQuestions();
        setupCards();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Common.countDownTimer.cancel();
        Common.currentQuestion =0;
        Common.questionNumbers.clear();
        Common.questionNumbers.size();
    }

    private void setupQuestions(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onPageSelected(int position) {
                Common.currentQuestion = position;
                setupCards();
                txt_question_right.setText((position + 1) + "/" + (Common.questionNumbers.size()));
                if (Common.currentQuestion == Common.lastQuestion) {
                    resultButton();
                } else {
                    resultButton.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        for (int i = 0; i<Common.questionNumbers.size(); i++){
            Common.chosenAnswers.add("E");
            AnswerSheetAdapter.colors.add(i, Color.parseColor("#34ebb4"));
        }
        Common.blankFragments.clear();
        genFragmentList();
        SavollarFragmentAdapter savollarFragmentAdapter = new SavollarFragmentAdapter(getSupportFragmentManager(),
                this, Common.blankFragments);
        viewPager.setAdapter(savollarFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setPageTransformer(false, new CubeOutTransformer());
    }
    private void genFragmentList() {
        for (int i = 0; i<Common.questionNumbers.size(); i++){
            Bundle bundle=new Bundle();
            bundle.putInt("index", i);
            BlankFragment fragment=new BlankFragment();
            fragment.setArguments(bundle);
            Common.blankFragments.add(fragment);
        }
    }
    private void setupCards() {
        answer_sheet_view = findViewById(R.id.grid_answer);
        answer_sheet_view.setHasFixedSize(true);
        answer_sheet_view.setLayoutManager(new GridLayoutManager(this, Common.questionNumbers.size()/2));
        answerSheetAdapter = new AnswerSheetAdapter(this, Common.currentQuestions);
        answer_sheet_view.setAdapter(answerSheetAdapter);
    }

    private void timer(){
        Common.countDownTimer=new CountDownTimer(Common.TOTAL_TIME_QUIZ, 1000) {
            @SuppressLint("DefaultLocale")
            @Override
            public void onTick(long l) {
                txt_timer.setText(String.format("%02d:%02d",
                        TimeUnit.MILLISECONDS.toMinutes(l),
                        TimeUnit.MILLISECONDS.toSeconds(l)
                                -TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))));
                time_lay-=1000;
            }
            @Override
            public void onFinish() {
                finishGame();

            }
        }.start();
    }
    public void finishGame(){
        Intent intent=new Intent(QuizActivity.this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("mylist", Common.questionNumbers);
        intent.putExtras(bundle);
        Common.timer=Common.TOTAL_TIME_QUIZ-time_lay;
        Common.countDownTimer.cancel();
        startActivity(intent);
    }

    private void resultButton(){
        resultButton.setVisibility(View.VISIBLE);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Common.chosenAnswers.contains("E")){
                    new MaterialAlertDialogBuilder(QuizActivity.this,
                            R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
                            .setTitle("Diqqat!!!")
                            .setCancelable(false)
                            .setMessage("Siz testni toliq belgilamadingiz, natijani bilishni hohlaysizmi")
                            .setPositiveButton("Ha", (dialog, which) -> finishGame())
                            .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                            .show();
                }else {
                    finishGame();
                }


            }
        });
    }
}