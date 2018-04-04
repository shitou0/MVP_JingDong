package com.example.mvp_jingdong.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_jingdong.R;

/**
 * Created by 石头 on 2018/3/23.
 */

public class MyHolder_MeiRiGuang extends RecyclerView.ViewHolder {

    private final ImageView meiriguang_image;
    private final TextView meiriguang_text;

    public MyHolder_MeiRiGuang(View itemView) {
        super(itemView);
        meiriguang_image = itemView.findViewById(R.id.meiriguang_image);
        meiriguang_text = itemView.findViewById(R.id.meiriguang_text);
    }


}
