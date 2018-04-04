package com.example.mvp_jingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mvp_jingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JiuGongGe_item_Activity extends AppCompatActivity {

    @BindView(R.id.jiugongge_webview)
    WebView jiugongge_Webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiu_gong_ge_item_);
        ButterKnife.bind(this);
        String deatilurl = getIntent().getStringExtra("deatilurl1");
        jiugongge_Webview.loadUrl(deatilurl);
        if (deatilurl!=null){
            jiugongge_Webview.loadUrl(deatilurl);
            jiugongge_Webview.setWebViewClient(new WebViewClient());
            WebSettings settings = jiugongge_Webview.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
    }
}
