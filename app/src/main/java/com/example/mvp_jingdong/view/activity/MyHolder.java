package com.example.mvp_jingdong.view.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvp_jingdong.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 石头 on 2018/3/23.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    public final ImageView jiugongge_img;
    public final TextView jiugongge_text;

    public MyHolder(View itemView) {
        super(itemView);
        jiugongge_img = itemView.findViewById(R.id.jiugongge_img);
        jiugongge_text = itemView.findViewById(R.id.jiugongge_text);
    }
}
