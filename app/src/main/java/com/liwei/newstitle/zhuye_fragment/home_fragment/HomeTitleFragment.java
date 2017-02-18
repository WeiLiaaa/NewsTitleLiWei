package com.liwei.newstitle.zhuye_fragment.home_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.liwei.newstitle.R;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.HomeTitleAdapter;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.WebViewJS;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.httputils.bean.HomeTitleFragmentBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by wu  suo  wei on 2017/2/12.
 */

public class HomeTitleFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2 {

    private View view;
    private PullToRefreshListView lv;
    private int i = 1;
    private HomeTitleAdapter adapter;
    private boolean falg = false;
    private List<HomeTitleFragmentBean.DataBean> data;

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
        initData(i, false);

    }

    private void initData(int index, final boolean falg) {
        String url_title = "http://ic.snssdk.com/2/article/v";
        //接收fragment传递的数据
        String url_hou = (String) getArguments().get("url");
        //获取网络请求地址url
        String url = url_title + index + url_hou;
        RequestParams params = new RequestParams(url);
        //xutils网络请求数据
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeTitleFragmentBean bean = gson.fromJson(result, HomeTitleFragmentBean.class);
                data = bean.getData();
                adapter.addData(data, falg);
                lv.setAdapter(adapter);
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    lv.onRefreshComplete();
                }
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
        //声明控件
        lv = (PullToRefreshListView) view.findViewById(R.id.home_fragment_lv);
        //设置listview的模式
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        //设置可上拉刷新和下拉刷新
        lv.setOnRefreshListener(this);
        //listview的点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getActivity(),WebViewJS.class);
                //跳转传值
                String uri = data.get(position).getShare_url();
                in.putExtra("webViewURI",uri);
                startActivity(in);
            }
        });

    }
    //下拉刷新
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        i = 1;
        initData(i, false);
    }
    //上拉加载
    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        i++;
        initData(i, true);

    }
}
