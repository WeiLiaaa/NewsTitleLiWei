package com.liwei.newstitle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.liwei.newstitle.adapter.ViewPagerAdapter;

import java.util.ArrayList;

/**
 * Created by wu  suo  wei on 2017/2/9.
 * 导航页面
 */

public class ViewpageDaohang extends AppCompatActivity {
    ViewPager vp;
    Button bu;
    LinearLayout ll;
    String [] path={"http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg",
            "http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg"};
    ImageView image_dots;
    ArrayList<ImageView> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化视图
        initView();
    }
    //初始化视图的方法
    private void initView() {
        setContentView(R.layout.viewpagedaohang);
        //声明控件
        vp = (ViewPager) findViewById(R.id.viewPager_vp);
        bu = (Button) findViewById(R.id.viewPager_bu);
        ll = (LinearLayout) findViewById(R.id.viewPage_ll);
        vp.setAdapter(new ViewPagerAdapter(ViewpageDaohang.this,path));
        //添加小点
        initDots();
        //设置viewpager的点击事件
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < list.size(); i++) {
                    if(i==position){
                        list.get(i).setImageResource(R.drawable.image_select);
                    }else{
                        list.get(i).setImageResource(R.drawable.image);
                    }
                }
                if(position==2){
                    bu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //button的点击事件
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(ViewpageDaohang.this,ZhuYeActivity.class);
                startActivity(in);
                finish();
            }
        });
    }

    private void initDots() {
        list=new ArrayList<ImageView>();
        for (int i = 0; i < path.length; i++) {
            image_dots= new ImageView(this);
            if(i==0){
                image_dots.setImageResource(R.drawable.image_select);
            }
            else{
                image_dots.setImageResource(R.drawable.image);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(30, 30);
            //设置点之间的间距
            params.setMargins(15, 0, 15, 0);
            //把点添加到linearlayout中
            ll.addView(image_dots, params);
            //把点添加到集合中
            list.add(image_dots);
        }
    }
}
