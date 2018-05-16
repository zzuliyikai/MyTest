package com.yikai.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main3Activity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        webView = findViewById(R.id.webView);

        initSetting();

        webView.loadUrl("http://192.168.0.111:8080/1525954598657.html");

    }

    private void initSetting() {
        WebSettings mWebSettings = webView.getSettings();
        //支持与js进行交互
        mWebSettings.setJavaScriptEnabled(true);
        //将图片调整到适合webview的大小
        mWebSettings.setUseWideViewPort(true);
        // 缩放至屏幕的大小
        mWebSettings.setLoadWithOverviewMode(true);
        //支持屏幕的缩放
        mWebSettings.setSupportZoom(true);
        mWebSettings.setBuiltInZoomControls(true);
        //使用webView的缓存
        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //设置可以访问文件
        mWebSettings.setAllowFileAccess(true);
        //设置应用的缓存路径
        mWebSettings.setAppCachePath(getCacheDir().getPath());
        //支持html里面的视频
        mWebSettings.setPluginState(WebSettings.PluginState.ON);
        webView.setWebChromeClient(new WebChromeClient());

        //不用调用系统浏览器
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
