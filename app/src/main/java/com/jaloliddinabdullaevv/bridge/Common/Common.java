package com.jaloliddinabdullaevv.bridge.Common;

import android.os.CountDownTimer;

import com.jaloliddinabdullaevv.bridge.Fragment.BlankFragment;
import com.jaloliddinabdullaevv.bridge.Model.CurrentQuestion;
import com.jaloliddinabdullaevv.bridge.Model.DescriptionObjects;
import com.jaloliddinabdullaevv.bridge.Model.SavolNomer;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static ArrayList<BlankFragment> blankFragments=new ArrayList<>();

    public static List<CurrentQuestion> currentQuestions =new ArrayList<>();
    public static CountDownTimer countDownTimer;
    public static ArrayList<SavolNomer> savolNomers =new ArrayList<>();
    public static int hozirgiSavol=0, engOxirgiList;
    public static List<String> tenlanganJavoblar=new ArrayList<>();
    public static final int TOTAL_TIME_QUIZ = 120 * 1000;
    public static int timer=0;
    public static List<String> togriJavoblarDatabasedan=new ArrayList<>();
    public static String imageName;
    public static DescriptionObjects descriptionObjects= new DescriptionObjects();
    public static final String DB_LINK = "https://bridgehackathon-71bb2-default-rtdb.europe-west1.firebasedatabase.app/";
}
