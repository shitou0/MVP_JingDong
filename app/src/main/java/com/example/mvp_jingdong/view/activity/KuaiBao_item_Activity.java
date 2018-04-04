package com.example.mvp_jingdong.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mvp_jingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KuaiBao_item_Activity extends AppCompatActivity {

    @BindView(R.id.kuaibao_webview)
    WebView kuaibao_Webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuai_bao_item_);
//        黄油刀获取 id
        ButterKnife.bind(this);
//        deatilurl  接受刚才的暗号
        String deatilurl = getIntent().getStringExtra("deatilurl");
        kuaibao_Webview.loadUrl(deatilurl);

        if (deatilurl!=null){
            kuaibao_Webview.loadUrl(deatilurl);
//            WebViewClient会在一些影响内容喧嚷的动作发生时被调用，比如表单的错误提交需要重新提交、页面开始加载及加载完成、资源加载中、接收到http认证需要处理、页面键盘响应、页面中的url打开处理等等
            kuaibao_Webview.setWebViewClient(new WebViewClient());
//            去掉中间 跳转的 bug 跳转中途没有空白页
            WebSettings settings = kuaibao_Webview.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
    }
}
