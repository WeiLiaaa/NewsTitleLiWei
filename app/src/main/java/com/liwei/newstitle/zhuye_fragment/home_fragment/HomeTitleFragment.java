package com.liwei.newstitle.zhuye_fragment.home_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.liwei.newstitle.R;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.HomeTitleAdapter;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.httputils.bean.HomeTitleFragmentBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by wu  suo  wei on 2017/2/12.
 */

public class HomeTitleFragment extends Fragment {

    private View view;
    private ListView lv;

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
        //初始化view
        initView();
        //初始化数据
        initData();


    }

    private void initData() {
        String url = (String) getArguments().get("url");
        //TextView tv= (TextView) vie.findViewById(R.id.tv);
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeTitleFragmentBean bean = gson.fromJson(result, HomeTitleFragmentBean.class);
                List<HomeTitleFragmentBean.DataBean> data = bean.getData();
                //设置adapter
                HomeTitleAdapter adapter=new HomeTitleAdapter(getActivity());
                lv.setAdapter(adapter);
                adapter.addData(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView() {
        lv = (ListView) view.findViewById(R.id.home_fragment_lv);
    }
}
