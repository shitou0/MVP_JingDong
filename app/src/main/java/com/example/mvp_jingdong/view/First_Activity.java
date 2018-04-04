package com.example.mvp_jingdong.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.example.mvp_jingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class First_Activity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    SharedPreferences preferences;
    Handler handler = new Handler();
    SharedPreferences.Editor editor;
    // 设置跳转时长
    int time = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_first_);
        preferences = getSharedPreferences("cof", MODE_PRIVATE);
        editor = preferences.edit();
        boolean Login = preferences.getBoolean("isLogin", false);
        if (Login) {
            Intent intent = new Intent(First_Activity.this, FirstActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv.setText(time + "");
                time--;
                if (time == 0) {
                    Intent intent = new Intent(First_Activity.this, FirstActivity.class);
                    startActivity(intent);
                    //进行判断是否第一次
                    editor.putBoolean("isLogin", true);
                    editor.commit();
                    finish();
                    return;
                }
                handler.postDelayed(this, 1000);
            }
        }, 1000);
    }
}
