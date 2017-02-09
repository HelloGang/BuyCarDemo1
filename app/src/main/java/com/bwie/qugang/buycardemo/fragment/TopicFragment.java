package com.bwie.qugang.buycardemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.qugang.buycardemo.R;

/**
 * 1.类的用途：
 * 2.@author
 * 3.@date
 */
public class TopicFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.topic_fragment, null);
        return view;
    }
}
