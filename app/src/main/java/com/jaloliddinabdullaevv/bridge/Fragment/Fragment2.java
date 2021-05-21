package com.jaloliddinabdullaevv.bridge.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.jaloliddinabdullaevv.bridge.R;

public class Fragment2 extends Fragment {
    TextView textView;
    TextView title;
    ImageView logo;

    MaterialButton materialButton;
    ViewPager viewPager;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_fragment_2, container, false);
        textView=view.findViewById(R.id.author);
        logo=view.findViewById(R.id.logo);
        title=view.findViewById(R.id.title);

        return view;
    }

}