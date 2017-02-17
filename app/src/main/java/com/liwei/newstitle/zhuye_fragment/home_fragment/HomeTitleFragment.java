package com.liwei.newstitle.zhuye_fragment.home_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
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

public class HomeTitleFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2{

    private View view;
    private PullToRefreshListView lv;
    private int i=1;
    HomeTitleAdapter adapter;

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
        adapter = new HomeTitleAdapter(getActivity());
        //初始化数据
        initData(i);

    }

    private void initData(int index) {
        String url_title="http://ic.snssdk.com/2/article/v";
        //接收fragment传递的数据
        String url_hou = (String) getArguments().get("url");
        String url=url_title+index+url_hou;
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeTitleFragmentBean bean = gson.fromJson(result, HomeTitleFragmentBean.class);
                List<HomeTitleFragmentBean.DataBean> data = bean.getData();
                //设置adapter
                adapter.addData(data);
                lv.setAdapter(adapter);

                adapter.notifyDataSetChanged();
                lv.onRefreshComplete();
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
        lv = (PullToRefreshListView) view.findViewById(R.id.home_fragment_lv);
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        //设置可上拉刷新和下拉刷新
        lv.setOnRefreshListener(this);

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        i=1;
        initData(i);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        i++;
        initData(i);

    }
}
