package com.jaloliddinabdullaevv.bridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.jaloliddinabdullaevv.bridge.Adapter.HeroAdapter;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.HeroObject;

import java.util.ArrayList;
import java.util.List;

public class HeroListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter pagerAdapter;
    private RecyclerView.LayoutManager chatListLayoutManager;
    private List<HeroObject> objects;

    private MaterialToolbar materialToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_list);


        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.teal_200));

        materialToolbar=findViewById(R.id.mToolbar);
        String matcher= Common.descriptionObjects.getDescription();


        String[] heroObjectString = new String[0];
        String[] heroInfo;
        if (matcher.startsWith("V-")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_1_1_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_1_1_uz1);
            materialToolbar.setTitle("V - IX asrlar");
        }else if (matcher.startsWith("X-")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_1_2_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_1_2_uz1);
            materialToolbar.setTitle("X - XIV asrlar");
        }else if (matcher.startsWith("XV")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_1_3_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_1_3_uz1);
            materialToolbar.setTitle("XV - XIX asrlar");
        }else if (matcher.startsWith("An")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_2_1_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_2_1_uz1);
            materialToolbar.setTitle("Aniq fanlar");
        }else if (matcher.startsWith("Ta")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_2_2_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_2_2_uz1);
            materialToolbar.setTitle("Tabiiy fanlar");
        }else if (matcher.startsWith("Ij")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_2_3_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_2_3_uz1);
            materialToolbar.setTitle("Ijtimoiy Gumanitar");
        }else if (matcher.startsWith("Di")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_2_4_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_2_4_uz1);
            materialToolbar.setTitle("Din va Jamiyat");
        }else if (matcher.startsWith("Ja")){
            heroObjectString=getResources().getStringArray(R.array.hero_list_2_5_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_2_5_uz1);
            materialToolbar.setTitle("Jadidchilik");
        }else {
            heroObjectString=getResources().getStringArray(R.array.hero_list_2_6_uz);
            heroInfo=getResources().getStringArray(R.array.hero_list_2_6_uz1);
            materialToolbar.setTitle("Adabiyot va Sanat");
        }


        objects=new ArrayList<>();
        initializeRecyclerView();


        for (int i=0; i<heroObjectString.length; i++){
            HeroObject heroObject=new HeroObject();
            heroObject.setHeroName(heroObjectString[i]);
            heroObject.setHeroInfo(heroInfo[i]);
            objects.add(heroObject);
        }
        pagerAdapter.notifyDataSetChanged();
    }

    @SuppressLint("WrongConstant")
    private void initializeRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        chatListLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL, false);
        recyclerView.setLayoutManager(chatListLayoutManager);
        pagerAdapter = new HeroAdapter(HeroListActivity.this, objects);
        recyclerView.setAdapter(pagerAdapter);
    }
}