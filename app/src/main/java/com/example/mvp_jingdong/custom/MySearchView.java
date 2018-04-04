package com.example.mvp_jingdong.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.mvp_jingdong.R;

/**自定义  搜索  框
 * Created by 石头 on 2018/3/23.
 */

public class MySearchView extends LinearLayout {
    private EditText ev_content;

    //直接new处理
    public MySearchView(Context context) {
        this(context,null);
    }

    //在布局文件里面可用
//    AttributeSet  属性集
    public MySearchView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    //手动调用
//    defStyleAttr默认属性
    public MySearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //   初始化一些东西
        View view = View.inflate(context, R.layout.layout_mysearchview,this);
        //   找到控件
        ev_content = view.findViewById(R.id.content);
    }
    //   提供一个外部访问的方法，将输入的内容传出去。
    //  在主方法里面进行调用，取值
    public String getContent(){
        return ev_content.getText().toString();
    }

}
