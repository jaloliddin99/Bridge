package com.jaloliddinabdullaevv.bridge.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.card.MaterialCardView;
import com.jaloliddinabdullaevv.bridge.Description;
import com.jaloliddinabdullaevv.bridge.R;
import com.jaloliddinabdullaevv.bridge.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    MaterialCardView mainPageCard, interestingInfoCard, questionCard, getMoneyCard;
    RelativeLayout rel1, rel2, rel3, rel4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        rel1=root.findViewById(R.id.rel1);
        rel2=root.findViewById(R.id.rel2);
        rel3=root.findViewById(R.id.rel3);
        rel4=root.findViewById(R.id.rel4);

        mainPageCard=root.findViewById(R.id.mainPageCard);
        interestingInfoCard=root.findViewById(R.id.interestingInfoCard);
        questionCard=root.findViewById(R.id.questionCard);
        getMoneyCard=root.findViewById(R.id.getMoneyCard);


        rel1.setTranslationX(1100);
        rel1.animate().translationXBy(-1100).setDuration(2000);
        rel2.setTranslationX(-1100);
        rel2.animate().translationXBy(1100).setDuration(2000);
        rel3.setTranslationX(1100);
        rel3.animate().translationXBy(-1100).setDuration(2000);
        rel4.setTranslationX(-1100);
        rel4.animate().translationXBy(1100).setDuration(2000);


        mainPageCard.setOnClickListener(v -> {
            Intent intent=new Intent(v.getContext(), Description.class);
            v.getContext().startActivity(intent);
        });
        interestingInfoCard.setOnClickListener(v -> {

        });
        questionCard.setOnClickListener(v -> {

        });
        getMoneyCard.setOnClickListener(v -> {

        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}