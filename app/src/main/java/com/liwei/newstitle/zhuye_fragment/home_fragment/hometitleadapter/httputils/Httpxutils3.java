package com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.httputils;

import com.google.gson.Gson;
import com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter.httputils.bean.HomeTitleFragmentBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by wu  suo  wei on 2017/2/16.
 * 网络请求数据
 */

public class Httpxutils3 {

    public static void httpData(String url, final DataHttp datahttp){

        RequestParams params = new RequestParams(url);
        //xutils网络请求数据
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeTitleFragmentBean bean = gson.fromJson(result, HomeTitleFragmentBean.class);
                datahttp.dataBean(bean);
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
    public interface DataHttp<T>{
        void dataBean(T t);
    }

}
