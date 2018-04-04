package com.example.mvp_jingdong.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.custom.NetTypeUtils;
import com.example.mvp_jingdong.view.fragment.Radio_faxian;
import com.example.mvp_jingdong.view.fragment.Radio_fenlei;
import com.example.mvp_jingdong.view.fragment.Radio_gouwuche;
import com.example.mvp_jingdong.view.fragment.Radio_shouye;
import com.example.mvp_jingdong.view.fragment.Radio_wode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.rb_shouye)
    RadioButton rb_Shouye;
    @BindView(R.id.rb_fenlei)
    RadioButton rb_Fenlei;
    @BindView(R.id.rb_faxian)
    RadioButton rb_Faxian;
    @BindView(R.id.rb_gouwuche)
    RadioButton rb_Gouwuche;
    @BindView(R.id.rb_wode)
    RadioButton rb_Wode;
    @BindView(R.id.radio_group)
    RadioGroup radio_Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        设置默认展示界面
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, new Radio_shouye()).commit();
//      设置 radiobutton  默认展示为红色
        radio_Group.check(R.id.rb_shouye);


    }

    @OnClick({R.id.rb_shouye, R.id.rb_fenlei, R.id.rb_faxian, R.id.rb_gouwuche, R.id.rb_wode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_shouye:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Radio_shouye()).commit();
                break;
            case R.id.rb_fenlei:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Radio_fenlei()).commit();
                break;
            case R.id.rb_faxian:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Radio_faxian()).commit();
                break;
            case R.id.rb_gouwuche:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Radio_gouwuche()).commit();
                break;
            case R.id.rb_wode:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Radio_wode()).commit();
                break;
        }
    }
}
