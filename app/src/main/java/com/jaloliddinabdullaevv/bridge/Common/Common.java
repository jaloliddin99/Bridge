package com.jaloliddinabdullaevv.bridge.Common;

import android.os.CountDownTimer;

import com.jaloliddinabdullaevv.bridge.Fragment.BlankFragment;
import com.jaloliddinabdullaevv.bridge.Model.CurrentQuestion;
import com.jaloliddinabdullaevv.bridge.Model.DescriptionObjects;
import com.jaloliddinabdullaevv.bridge.Model.QuestionNumber;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static ArrayList<BlankFragment> blankFragments=new ArrayList<>();
    public static int correctAnswer =0;
    public static List<CurrentQuestion> currentQuestions =new ArrayList<>();
    public static CountDownTimer countDownTimer;
    public static ArrayList<QuestionNumber> questionNumbers =new ArrayList<>();
    public static int currentQuestion =0, lastQuestion;
    public static List<String> chosenAnswers =new ArrayList<>();
    public static final int TOTAL_TIME_QUIZ = 120 * 1000;
    public static int timer=0;
    public static List<String> correctAnswersFromDb =new ArrayList<>();
    public static String imageName;
    public static DescriptionObjects descriptionObjects= new DescriptionObjects();
    public static List<String> onlineDCorrectAnswers =new ArrayList<>();
    public static List<String> chosenOnlineDBAnswers =new ArrayList<>();
    public static final String DB_LINK = "https://bridgehackathon-71bb2-default-rtdb.europe-west1.firebasedatabase.app/";
}
