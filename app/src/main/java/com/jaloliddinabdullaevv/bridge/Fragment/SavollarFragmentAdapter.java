package com.jaloliddinabdullaevv.bridge.Fragment;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jaloliddinabdullaevv.bridge.Common.Common;

import java.util.List;

public class SavollarFragmentAdapter extends FragmentPagerAdapter {
    Context context;
    List<BlankFragment> fragments;
    public SavollarFragmentAdapter(@NonNull FragmentManager fm, Context context, List<BlankFragment> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Log.i("eng Oxirgi List ", String.valueOf(position));

        Common.lastQuestion =position;
        return new StringBuilder("Savol ").append(position+1).toString();
    }
}
