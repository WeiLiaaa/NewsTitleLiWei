package com.liwei.newstitle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iamge;
    AnimationSet as;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化view界面
        initView();
        //设置动画
        setAnimation();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        iamge = (ImageView) findViewById(R.id.image);
    }

    //设置动画方法
    private void setAnimation() {
        /**
         * AnimationSet  支持组合多种渐变效果
         * false  代表动画都采用自己的动画插入器
         */
        as=new AnimationSet(false);
        //透明动画
        AlphaAnimation al = new AlphaAnimation(0,1);
        //设置动画时间
        al.setDuration(3000);
        //动画播放完停留在播放完的状态
        al.setFillAfter(true);
        //添加到动画集里面
        as.addAnimation(al);
        //位移动画
        TranslateAnimation ta=new TranslateAnimation(0,300,0,200);
        //设置动画时间
        ta.setDuration(3000);
        //动画播放完停留在播放完的状态
        ta.setFillAfter(true);
        //添加到动画集里面
        as.addAnimation(ta);
        //旋转动画
        RotateAnimation ra=new RotateAnimation(
                0,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        //设置动画时间
        ra.setDuration(3000);
        //动画播放完停留在播放完的状态
        ra.setFillAfter(true);
        //添加到动画集里面
        as.addAnimation(ra);
        //缩放动画
        ScaleAnimation sa=new ScaleAnimation(0,1,0,1,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        //设置动画时间
        sa.setDuration(3000);
        //动画播放完停留在播放完的状态
        sa.setFillAfter(true);
        //添加到动画集里面
        as.addAnimation(sa);
        //开始动画
        iamge.startAnimation(as);
        //动画的监听事件
        animationinit();
    }

    private void animationinit() {
        as.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                SharedPreferences sp = getSharedPreferences("cun",MODE_PRIVATE);
                /*Intent in=new Intent(MainActivity.this,ViewpageDaohang.class);
                startActivity(in);*/


                /**
                 * 判断
                 * 第一次进入导航页面
                 * dier次进入主页面
                 */
                if (sp.getBoolean("flge",false)){
                    Intent in=new Intent(MainActivity.this,ZhuYeActivity.class);
                    startActivity(in);
                    finish();
                }else{

                    Intent in2=new Intent(MainActivity.this,ViewpageDaohang.class);
                    startActivity(in2);
                    sp.edit().putBoolean("flge",true).commit();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
