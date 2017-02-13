package com.liwei.newstitle.zhuye_fragment.fragmentadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wu  suo  wei on 2017/2/12.
 */

public class HomeTitleAdapter extends FragmentPagerAdapter {
    Context context;
    ArrayList<String> title;
    ArrayList<Fragment> list_fragment;

    public HomeTitleAdapter(FragmentManager fragmentManager, Context context,
                            ArrayList<String> title, ArrayList<Fragment> list_fragment) {
        super(fragmentManager);
        this.context = context;
        this.title = title;
        this.list_fragment = list_fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }
}
