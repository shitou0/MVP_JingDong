package com.example.mvp_jingdong.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.custom.NetTypeUtils;

public class FirstActivity extends AppCompatActivity {
    Handler handler = new Handler();
    private TextView time;
    int shijian = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //首先判断有没有连接网络
        boolean result = NetTypeUtils.isConn(FirstActivity.this);
        if (result) {
            //进行请求网络  数据（HttpUrl）

            time = (TextView) findViewById(R.id.time);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    time.setText(""+shijian+"秒跳转");
                    shijian--;
                    if (shijian == 0) {
                        Intent intent = new Intent(FirstActivity.this,MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.leftin, R.anim.leftout);
                        finish();
                    }
                    handler.postDelayed(this,1000);
                }
            }, 1000);
        } else {
            NetTypeUtils.openNetSettingDg(FirstActivity.this);
        }
    }
}
