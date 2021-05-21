package com.jaloliddinabdullaevv.bridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.card.MaterialCardView;
import com.jaloliddinabdullaevv.bridge.Adapter.DescriptionAdapter;
import com.jaloliddinabdullaevv.bridge.Adapter.DesctiptionAdapter2;
import com.jaloliddinabdullaevv.bridge.Model.DescriptionObjects;

import java.util.ArrayList;
import java.util.List;

public class Description extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter pagerAdapter;
    private RecyclerView.LayoutManager chatListLayoutManager;
    private List<DescriptionObjects> objects;

    private RecyclerView recyclerView2;
    private RecyclerView.Adapter pagerAdapter2;
    private RecyclerView.LayoutManager chatListLayoutManager2;
    private List<DescriptionObjects> objects2;

    private MaterialCardView cardView, cardView2;
    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.teal_200));

        cardView = findViewById(R.id.cardView);
        cardView2 = findViewById(R.id.cardView2);
        scrollView = findViewById(R.id.scrollView);


        cardView.animate().translationXBy(-1100).setDuration(1000);
        cardView2.animate().translationXBy(1100).setDuration(1000);
        scrollView.animate().alpha(1.0f).setDuration(1000);


        objects = new ArrayList<>();
        objects2 = new ArrayList<>();
        initializeRecyclerView();
        initializeRecyclerView2();
        String[] descriptionPart1 = getResources().getStringArray(R.array.descriptionPart1);
        String[] descriptionPart2 = getResources().getStringArray(R.array.descriptionPart2);

        for (String value : descriptionPart1) {
            DescriptionObjects descriptionObjects = new DescriptionObjects();
            descriptionObjects.setDescription(value);
            objects.add(descriptionObjects);
        }
        pagerAdapter.notifyDataSetChanged();

        for (String s : descriptionPart2) {
            DescriptionObjects descriptionObjects = new DescriptionObjects();
            descriptionObjects.setDescription(s);
            objects2.add(descriptionObjects);
        }
        pagerAdapter2.notifyDataSetChanged();
    }

    @SuppressLint("WrongConstant")
    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        chatListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(chatListLayoutManager);
        pagerAdapter = new DescriptionAdapter(Description.this, objects);
        recyclerView.setAdapter(pagerAdapter);
    }

    @SuppressLint("WrongConstant")
    private void initializeRecyclerView2() {
        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.setNestedScrollingEnabled(true);
        recyclerView2.setHasFixedSize(false);
        chatListLayoutManager2 = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL, false);
        recyclerView2.setLayoutManager(chatListLayoutManager2);
        pagerAdapter2 = new DesctiptionAdapter2(Description.this, objects2);
        recyclerView2.setAdapter(pagerAdapter2);
    }
}