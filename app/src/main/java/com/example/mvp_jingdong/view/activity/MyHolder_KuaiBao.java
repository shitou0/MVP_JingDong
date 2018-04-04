package com.example.mvp_jingdong.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_jingdong.R;

/**
 * Created by 石头 on 2018/3/23.
 */

public class MyHolder_KuaiBao extends RecyclerView.ViewHolder {

    public final ImageView kuaibao_img;


    public MyHolder_KuaiBao(View itemView) {
        super(itemView);
        kuaibao_img = itemView.findViewById(R.id.kuaibao_image);
    }
}
