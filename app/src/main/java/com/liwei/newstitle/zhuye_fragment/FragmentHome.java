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
import com.liwei.newstitle.zhuye_fragment.home_fragment.HomeTitleFragment;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.HomeTitleAdapterzhu;

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
    private ArrayList<String> newsURL;

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
        title.add("汽车");
        title.add("体育");
        title.add("美女");
        title.add("军事");
        //新闻接口
        newsURL = new ArrayList<>();
        newsURL.add("/stream/");
        newsURL.add("/stream/?category=news_hot");
        newsURL.add("/stream/?category=video");
        newsURL.add("/stream/?category=news_society" +
                "&count=20&min_behot_time=1478258618&bd_latitude=4.9E-324&bd_longitude=4.9" +
                "E-324&bd_loc_time=1478258163&loc_mode=5&lac=0&cid=0&iid=6104095051&device" +
                "_id=32027644242&ac=wifi&channel=baidu&aid=13&app_name=news_article&versio" +
                "n_code=460&device_platform=android&device_type=Samsung%20Galaxy%20S3%20-%204.3" +
                "%20-%20API%2018%20-%20720x1280&os_api=18&os_version=4.3&openudid=e468d99fa5f6c91f");
        newsURL.add("/stream/?category=news_entert" +
                "ainment&count=20&min_behot_time=1455522338&bd_city=%E5%8C%97%E4%BA%AC" +
                "%E5%B8%82&bd_latitude=40.049317&bd_longitude=116.296499&bd_loc_time=145552278" +
                "4&loc_mode=5&lac=4527&cid=28883&iid=3642583580&device_id=11131669133&ac=wifi&ch" +
                "annel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android" +
                "&device_type=SCH-I919U&os_api=19&os_version=" +
                "4.4.2&uuid=285592931621751&openudid=AC9E172CE2490000");
        newsURL.add("/stream/?category=news_car&count=20&min_beh" +
                "ot_time=1478259079&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time=147825" +
                "8884&loc_mode=5&lac=0&cid=0&iid=6104095051&device_id=32027644242&ac=wifi&channe" +
                "l=baidu&aid=13&app_name=news_article&version_code=460&device_platform=android&devi" +
                "ce_type=Samsung%20Galaxy%20S3%20-%204.3%20-%20API%2018%20-%20720x1280&os_api=18&os" +
                "_version=4.3&openudid=e468d99fa5f6c91f");
        newsURL.add("/stream/?category=news_sports&count=20&m" +
                "in_behot_time=1478259221&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time" +
                "=1478258884&loc_mode=5&lac=0&cid=0&iid=6104095051&device_id=32027644242&ac=wifi&ch" +
                "annel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=androi" +
                "d&device_type=Samsung%20Galaxy%20S3%20-%204.3%20-%20API%2018%20-%20720x1280&os_ap" +
                "i=18&os_version=4.3&openudid=e468d99fa5f6c91f");
        newsURL.add("/stream/?category=image_ppmm&count=20&m" +
                "in_behot_time=1478259471&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_tim" +
                "e=1478258884&loc_mode=5&lac=0&cid=0&iid=6104095051&device_id=32027644242&ac=wifi&c" +
                "hannel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=andr" +
                "oid&device_type=Samsung%20Galaxy%20S3%20-%204.3%20-%20API%2018%20-%20720x1280&os" +
                "_api=18&os_version=4.3&openudid=e468d99fa5f6c91f");
        newsURL.add("/stream/?category=news_military&count=20&mi" +
                "n_behot_time=1478259311&bd_latitude=4.9E-324&bd_longitude=4.9E-324&bd_loc_time" +
                "=1478258884&loc_mode=5&lac=0&cid=0&iid=6104095051&device_id=32027644242&ac=wifi&" +
                "channel=baidu&aid=13&app_name=news_article&version_code=460&device_platform=androi" +
                "d&device_type=Samsung%20Galaxy%20S3%20-%204.3%20-%20API%2018%20-%20720x1280&os_api" +
                "=18&os_version=4.3&openudid=e468d99fa5f6c91f");
        //添加Fragment集合
        initFragmentList();
        HomeTitleAdapterzhu adapter=new HomeTitleAdapterzhu(getFragmentManager(),getActivity(),
                title,list_fragment);
        home_vp.setAdapter(adapter);
        home_vp.setOffscreenPageLimit(3);

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
            bundle.putString("url", newsURL.get(i));
            //得到参数
            home_title_fragment.setArguments(bundle);
            list_fragment.add(home_title_fragment);
        }
    }
}
