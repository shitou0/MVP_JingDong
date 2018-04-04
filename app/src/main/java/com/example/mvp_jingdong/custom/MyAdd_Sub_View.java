package com.example.mvp_jingdong.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.mvp_jingdong.R;

import static android.content.ContentValues.TAG;

/**
 * Created by lenovo on 2018/3/24.
 */

public class MyAdd_Sub_View extends LinearLayout implements View.OnClickListener{

    private TextView sub;
    private TextView add;
    private EditText count;
    private AddClickListener addClickListener;
    private SubClickListener subClickListener;

    public MyAdd_Sub_View(Context context) {

        this(context, null);
    }

    public MyAdd_Sub_View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyAdd_Sub_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = View.inflate(context, R.layout.layout_customview_myadd_sub_view, this);
        sub = view.findViewById(R.id.sub);
        add = view.findViewById(R.id.add);
        count = view.findViewById(R.id.content);
        sub.setOnClickListener(this);
        add.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
     switch (view.getId()){
         //当id为减时
         case R.id.sub:
             String c = count.getText().toString();
             int i = Integer.parseInt(c);
             if (i<=0){
                 return;
             }
             count.setText(--i+"");
             subClickListener.onSubClick(view,i);
             Log.d(TAG, "减=======" + i);
             break;
         case R.id.add:
             String c1 = count.getText().toString();
             int i1 = Integer.parseInt(c1);
             count.setText(++i1+"");
             addClickListener.onAddClick(view,i1);
             Log.d(TAG, "onClick() returned:" + "加=======");
             break;
     }
    }

    public int getContent() {
        return Integer.parseInt(count.getText().toString().trim());
    }

    public void setContent(int s) {

        count.setText(s+"");
    }
    //定义一个可被外部调用的接口（加）
    public interface AddClickListener {
        void onAddClick(View view, int count);
    }

    // 定义一个可被外部调用的接口（减）
    public interface SubClickListener {
        void onSubClick(View view, int count);
    }

    public void SetAddClickListener(AddClickListener addClickListener){
        this.addClickListener=addClickListener;
    }

    public void SetSubClickListener(SubClickListener subClickListener) {
        this.subClickListener = subClickListener;
    }
}
