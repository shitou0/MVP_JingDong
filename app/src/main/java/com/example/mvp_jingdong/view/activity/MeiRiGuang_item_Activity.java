package com.example.mvp_jingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mvp_jingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MeiRiGuang_item_Activity extends AppCompatActivity {

    @BindView(R.id.meiriguang_webview)
    WebView meiriguang_Webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mei_ri_guang_item_);
        ButterKnife.bind(this);
        String deatilurl = getIntent().getStringExtra("deatilurl");
        meiriguang_Webview.loadUrl(deatilurl);
        if (deatilurl!=null){
            meiriguang_Webview.loadUrl(deatilurl);
            meiriguang_Webview.setWebViewClient(new WebViewClient());
            WebSettings settings = meiriguang_Webview.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }

    }
}
