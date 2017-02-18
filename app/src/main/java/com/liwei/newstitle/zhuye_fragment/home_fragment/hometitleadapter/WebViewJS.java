package com.liwei.newstitle.zhuye_fragment.home_fragment.hometitleadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.liwei.newstitle.R;

/**
 * Created by wu  suo  wei on 2017/2/17.
 */

public class WebViewJS extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewjs);
        //初始化控件
        initView();
    }

    private void initView() {
        WebView webViewJS = (WebView) findViewById(R.id.webViewJS);
        Intent intent = getIntent();
        String webViewURI = intent.getStringExtra("webViewURI");
        //js交互
        webViewJS.loadUrl(webViewURI);
    }
}
