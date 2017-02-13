package com.liwei.newstitle.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.liwei.newstitle.R;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by wu  suo  wei on 2017/2/9.
 */

public class ViewPagerAdapter extends PagerAdapter {
    String[] path;
    Context context;

    public ViewPagerAdapter(Context context, String[] path) {
        this.context = context;
        this.path = path;
    }

    @Override
    public int getCount() {
        return path.length;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.vpdaohang_item, null);
        ImageView image = (ImageView) view.findViewById(R.id.vp_item_image);
        //设置图片
        ImageLoader.getInstance().displayImage(path[position], image);
        //添加view到ViewGroup
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
