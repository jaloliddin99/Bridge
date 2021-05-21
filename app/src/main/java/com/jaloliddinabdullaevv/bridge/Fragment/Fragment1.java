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

public class Fragment1 extends Fragment {


    TextView title;
    ImageView logo;
    MaterialButton materialButton;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_fragment_1, container, false);

        logo=view.findViewById(R.id.logo);
        title=view.findViewById(R.id.title);
//        logo.setTranslationY(-500f);
//        logo.animate().translationYBy(500f)
//                .setDuration(2000).setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                textView.setCharacterDelay(100);
//                textView.animateText("");
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//                textView.animateText(getString(R.string.intro_text));
//                title.animate().alpha(1.0f).setDuration(1000);
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });

        return view;
    }


}