package com.example.hp450.tap;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hp 450 on 3/24/2018.
 */

public class FragmentCall extends Fragment {

    public FragmentCall()
    {

    }

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.call_fragment,container,false);
        return view;
    }
}