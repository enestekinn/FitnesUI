package com.example.fitnesui.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.fitnesui.fragment.Details;
import com.example.fitnesui.fragment.FitnessPicturesClass;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment selectedFragment;

        switch (position) {
            case 0:
                selectedFragment = FitnessPicturesClass.newInstance();
                break;
            case 1:
                selectedFragment = Details.newInstance();
                break;
            default:
                return null;
        }
        return selectedFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        CharSequence selectedTitle;
        switch (position) {
            case 0:
                selectedTitle = "Fitness Picture";
                break;
            case 1:
                selectedTitle = "Details";
                break;
            default:
                return null;
        }
        return selectedTitle;

    }
}
