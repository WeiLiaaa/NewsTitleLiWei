package com.liwei.newstitle.zhuye_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liwei.newstitle.R;

/**
 * Created by wu  suo  wei on 2017/2/10.
 */

public class FragmentCare extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_care, container, false);
        return view;
    }
}
