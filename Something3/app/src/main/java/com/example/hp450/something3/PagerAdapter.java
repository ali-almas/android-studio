package com.example.hp450.something3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int mNoOfTabs;
    public PagerAdapter(FragmentManager fm,int numberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                
            return null;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
