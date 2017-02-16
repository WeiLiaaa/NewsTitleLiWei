package com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.liwei.newstitle.R;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.bean.HomeTitleFragmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu  suo  wei on 2017/2/14.
 */

public class HomeTitleAdapter extends BaseAdapter {
    final int TYPE1 = 0;
    final int TYPE2 = 1;
    final int TYPE3 = 2;
    final int TYPE4 = 3;
    Context context;
    List<HomeTitleFragmentBean.DataBean> datas = new ArrayList<>();

    public HomeTitleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.home_fragment_item, null);
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    public void addData(List<HomeTitleFragmentBean.DataBean> data) {
        if (data != null) {
            datas.addAll(data);
        }
    }
}
