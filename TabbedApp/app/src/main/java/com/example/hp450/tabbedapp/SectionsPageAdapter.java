package com.example.hp450.tabbedapp;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp 450 on 3/23/2018.
 */

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> myFragmentList = new ArrayList<>();
    private final List<String> myFragmentTitleList = new ArrayList<>();

    public void addFragments(Fragment fragment,String title)
    {
        myFragmentList.add(fragment);
        myFragmentTitleList.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return myFragmentTitleList.get(position);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if(myFragmentList.get(position) == null)
            return myFragmentList.get(position);
        return null;
    }

    @Override
    public int getCount() {
        return myFragmentList.size();
    }
}
