package com.liwei.newstitle.zhuye_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liwei.newstitle.R;
import com.liwei.newstitle.zhuye_fragment.fragmentadapter.HomeTitleAdapter;
import com.liwei.newstitle.zhuye_fragment.home_fragment.HomeTitleFragment;

import java.util.ArrayList;

/**
 * Created by wu  suo  wei on 2017/2/10.
 */

public class FragmentHome extends Fragment {

    private View view;
    private ViewPager home_vp;
   //tab名称列表
    private ArrayList<String> title;
    //Fragment的集合
    private ArrayList<Fragment> list_fragment;
    private TabLayout home_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        home_vp = (ViewPager) view.findViewById(R.id.home_vp);
        title = new ArrayList<String>();
        //添加tab表明
        title.add("推荐");
        title.add("热点");
        title.add("阳光宽屏");
        title.add("社会");
        title.add("娱乐");
        title.add("问答");
        title.add("图片");
        title.add("汽车");
        title.add("体育");
        title.add("美女");
        title.add("军事");
        //添加Fragment集合
        initFragmentList();
        HomeTitleAdapter adapter=new HomeTitleAdapter(getFragmentManager(),getActivity(),
                title,list_fragment);
        home_vp.setAdapter(adapter);

        //声明tablayout控件
        home_title = (TabLayout) view.findViewById(R.id.home_title);
        //设置TabLayout的模式
        home_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        //把viewpager设置进联动事件
        home_title.setupWithViewPager(home_vp);

    }

    private void initFragmentList() {
        //创建集合
        list_fragment = new ArrayList<Fragment>();
        for(int i = 0; i < title.size(); i++){
            HomeTitleFragment home_title_fragment=new HomeTitleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", "type" + i);
            //得到参数
            home_title_fragment.setArguments(bundle);
            list_fragment.add(home_title_fragment);
        }
    }
}
