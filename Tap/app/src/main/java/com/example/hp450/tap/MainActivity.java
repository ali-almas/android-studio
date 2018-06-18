package com.example.hp450.tap;

import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragmentCall = getSupportFragmentManager().findFragmentById(R.id.call_fragment);
        Fragment fragmentContact = getSupportFragmentManager().findFragmentById(R.id.contact_fragment);
        Fragment fragmentFav = getSupportFragmentManager().findFragmentById(R.id.fav_fragment);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(fragmentCall,"Call");
        adapter.addFragment(fragmentContact,"Contact");
        adapter.addFragment(fragmentFav,"Favorite");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
