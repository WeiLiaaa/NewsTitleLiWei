package com.liwei.newstitle;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liwei.newstitle.zhuye_fragment.FragmentCare;
import com.liwei.newstitle.zhuye_fragment.FragmentDengLu;
import com.liwei.newstitle.zhuye_fragment.FragmentHome;
import com.liwei.newstitle.zhuye_fragment.FragmentVideo;

/**
 * Created by wu  suo  wei on 2017/2/9.
 * 主页面 显示四个按钮
 */

public class ZhuYeActivity extends AppCompatActivity implements View.OnClickListener {

    private FrameLayout zhuye_fl;
    //首页的控件
    private LinearLayout zhuye_home;
    private ImageView zhuye_home_image;
    private TextView zhuye_home_tv;
    //视频的控件
    private LinearLayout zhuye_video;
    private ImageView zhuye_video_image;
    private TextView zhuye_video_tv;
    //关注的控件
    private LinearLayout zhuye_care;
    private ImageView zhuye_care_image;
    private TextView zhuye_care_tv;
    //登录的控件
    private LinearLayout zhuye_dengLu;
    private ImageView zhuye_dengLu_image;
    private TextView zhuye_dengLu_tv;
    private FragmentManager fm;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhuyeactivity);
        //声明控件
        initView();
        //监听事件
        onClickonClickDemo();
        //得到FragmentManager
        fm = getSupportFragmentManager();
        //默认显示首页
        fm.beginTransaction().replace(R.id.zhuye_fl,new FragmentHome()).commit();
    }

    private void onClickonClickDemo() {
        zhuye_home.setOnClickListener(this);
        zhuye_video.setOnClickListener(this);
        zhuye_care.setOnClickListener(this);
        zhuye_dengLu.setOnClickListener(this);

    }

    //声明控件方法
    private void initView() {
        //FrameLayout控件
        zhuye_fl = (FrameLayout) findViewById(R.id.zhuye_fl);
        //首页的控件
        zhuye_home = (LinearLayout) findViewById(R.id.zhuye_home);
        zhuye_home_image = (ImageView) findViewById(R.id.zhuye_home_image);
        zhuye_home_tv = (TextView) findViewById(R.id.zhuye_home_tv);
        //视频的控件
        zhuye_video = (LinearLayout) findViewById(R.id.zhuye_video);
        zhuye_video_image = (ImageView) findViewById(R.id.zhuye_video_image);
        zhuye_video_tv = (TextView) findViewById(R.id.zhuye_video_tv);
        //关注的控件
        zhuye_care = (LinearLayout) findViewById(R.id.zhuye_care);
        zhuye_care_image = (ImageView) findViewById(R.id.zhuye_care_image);
        zhuye_care_tv = (TextView) findViewById(R.id.zhuye_care_tv);
        //登录的控件
        zhuye_dengLu = (LinearLayout) findViewById(R.id.zhuye_dengLu);
        zhuye_dengLu_image = (ImageView) findViewById(R.id.zhuye_dengLu_image);
        zhuye_dengLu_tv = (TextView) findViewById(R.id.zhuye_dengLu_tv);
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.zhuye_home:
                //显示首页
                fm.beginTransaction().replace(R.id.zhuye_fl,new FragmentHome()).commit();
                //改变控件颜色
                zhuye_home_image.setImageResource(R.drawable.b_newhome_tabbar_press);
                zhuye_home_tv.setTextColor(Color.RED);

                zhuye_video_image.setImageResource(R.drawable.b_newvideo_tabbar);
                zhuye_video_tv.setTextColor(Color.BLACK);

                zhuye_care_image.setImageResource(R.drawable.b_newcare_tabbar);
                zhuye_care_tv.setTextColor(Color.BLACK);

                zhuye_dengLu_image.setImageResource(R.drawable.b_newnologin_tabbar);
                zhuye_dengLu_tv.setTextColor(Color.BLACK);

                break;
            case R.id.zhuye_video:
                //显示视频
                fm.beginTransaction().replace(R.id.zhuye_fl,new FragmentVideo()).commit();
                //改变控件颜色
                zhuye_home_image.setImageResource(R.drawable.b_newhome_tabbar);
                zhuye_home_tv.setTextColor(Color.BLACK);

                zhuye_video_image.setImageResource(R.drawable.b_newvideo_tabbar_press);
                zhuye_video_tv.setTextColor(Color.RED);

                zhuye_care_image.setImageResource(R.drawable.b_newcare_tabbar);
                zhuye_care_tv.setTextColor(Color.BLACK);

                zhuye_dengLu_image.setImageResource(R.drawable.b_newnologin_tabbar);
                zhuye_dengLu_tv.setTextColor(Color.BLACK);
                break;
            case R.id.zhuye_care:
                //显示关注
                fm.beginTransaction().replace(R.id.zhuye_fl,new FragmentCare()).commit();
                //改变控件颜色
                zhuye_home_image.setImageResource(R.drawable.b_newhome_tabbar);
                zhuye_home_tv.setTextColor(Color.BLACK);

                zhuye_video_image.setImageResource(R.drawable.b_newvideo_tabbar);
                zhuye_video_tv.setTextColor(Color.BLACK);

                zhuye_care_image.setImageResource(R.drawable.b_newcare_tabbar_press);
                zhuye_care_tv.setTextColor(Color.RED);

                zhuye_dengLu_image.setImageResource(R.drawable.b_newnologin_tabbar);
                zhuye_dengLu_tv.setTextColor(Color.BLACK);
                break;
            case R.id.zhuye_dengLu:
                //显示登录
                fm.beginTransaction().replace(R.id.zhuye_fl,new FragmentDengLu()).commit();
                //改变控件颜色
                zhuye_home_image.setImageResource(R.drawable.b_newhome_tabbar);
                zhuye_home_tv.setTextColor(Color.BLACK);

                zhuye_video_image.setImageResource(R.drawable.b_newvideo_tabbar);
                zhuye_video_tv.setTextColor(Color.BLACK);

                zhuye_care_image.setImageResource(R.drawable.b_newcare_tabbar);
                zhuye_care_tv.setTextColor(Color.BLACK);

                zhuye_dengLu_image.setImageResource(R.drawable.b_newnologin_tabbar_press);
                zhuye_dengLu_tv.setTextColor(Color.RED);
                break;
        }
    }
}
