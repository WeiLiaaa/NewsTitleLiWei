package com.liwei.newstitle.zhuye_fragment.home_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liwei.newstitle.R;

/**
 * Created by wu  suo  wei on 2017/2/12.
 */

public class HomeTitleFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceSe) {

        view = inflater.inflate(R.layout.hometitle_fragment, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String url = (String) getArguments().get("url");
        //TextView tv= (TextView) view.findViewById(R.id.tv);


    }
}
