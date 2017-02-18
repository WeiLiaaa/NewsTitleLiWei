package com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liwei.newstitle.R;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.httputils.bean.HomeTitleFragmentBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu  suo  wei on 2017/2/14.
 */

public class HomeTitleAdapter extends BaseAdapter {
    final int TYPE1 = 0;
    final int TYPE2 = 1;
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
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    viewHolder1 = new ViewHolder1();
                    convertView = View.inflate(context, R.layout.homeadapter_item_type1, null);
                    viewHolder1.type1_name = (TextView) convertView.findViewById(R.id.homeadapter_item1_name);
                    viewHolder1.type1_image1 = (ImageView) convertView.findViewById(R.id.homeadapter_item1_image1);
                    viewHolder1.type1_image2 = (ImageView) convertView.findViewById(R.id.homeadapter_item1_image2);
                    viewHolder1.type1_image3 = (ImageView) convertView.findViewById(R.id.homeadapter_item1_image3);
                    convertView.setTag(viewHolder1);
                    break;
                case TYPE2:
                    viewHolder2 = new ViewHolder2();
                    convertView = View.inflate(context, R.layout.homeadapter_item_type2, null);
                    viewHolder2.type2_name = (TextView) convertView.findViewById(R.id.homeadapter_item2_name);
                    viewHolder2.type2_image = (ImageView) convertView.findViewById(R.id.homeadapter_item2_image);
                    convertView.setTag(viewHolder2);
                    break;
            }
        } else {
            switch (type) {
                case TYPE1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    viewHolder1.type1_name.setText(datas.get(position).getKeywords());
                    ImageLoader.getInstance().displayImage(datas.get(position).
                            getImage_list().get(0).getUrl(),viewHolder1.type1_image1);
                    ImageLoader.getInstance().displayImage(datas.get(position).
                            getImage_list().get(1).getUrl(),viewHolder1.type1_image2);
                    ImageLoader.getInstance().displayImage(datas.get(position).
                            getImage_list().get(2).getUrl(),viewHolder1.type1_image3);
                    break;
                case TYPE2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    viewHolder2.type2_name.setText(datas.get(position).getKeywords());
                    ImageLoader.getInstance().displayImage(datas.get(position).
                            getMiddle_image().getUrl(),viewHolder2.type2_image);
                    break;
            }
        }

        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        if (datas.get(position).getImage_list().size() == 3) {
            return TYPE1;
        } else {
            return TYPE2;
        }
    }

    public void addData(List<HomeTitleFragmentBean.DataBean> data, boolean falg) {
        if (data != null) {
            if (falg){
                datas.addAll(data);
            }else{
                datas.clear();
            }
        }
    }

    class ViewHolder1 {
        TextView type1_name;
        ImageView type1_image1;
        ImageView type1_image2;
        ImageView type1_image3;
    }

    class ViewHolder2 {
        TextView type2_name;
        ImageView type2_image;
    }
}
