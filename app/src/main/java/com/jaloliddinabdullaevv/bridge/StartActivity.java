package com.jaloliddinabdullaevv.bridge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.jaloliddinabdullaevv.bridge.Adapter.SimpleFragmentPagerAdapter;
import com.jaloliddinabdullaevv.bridge.Fragment.Fragment3;

import me.relex.circleindicator.CircleIndicator;

public class StartActivity extends AppCompatActivity {
    public static FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.Theme_Koprik);
        setContentView(R.layout.activity_start);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        Fragment3.pref = StartActivity.this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        Fragment3.editor = Fragment3.pref.edit();
        boolean userFirstLogin= Fragment3.pref.getBoolean("key_name1", true);
        if(!userFirstLogin){
            Intent intent=new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#FFFF9800"));
            getSupportActionBar().hide();
            ViewPager viewPager = findViewById(R.id.viewpager);

            SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());

            viewPager.setAdapter(adapter);
//
//            CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
//            indicator.setViewPager(viewPager);
        }


    }


}