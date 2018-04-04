package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.shouye_bean.Jiugongge_Bean;
import com.example.mvp_jingdong.view.activity.JiuGongGe_item_Activity;
import com.example.mvp_jingdong.view.activity.MyHolder;

import java.util.List;

/**
 * Created by 石头 on 2018/3/23.
 */

public class JiuGongGe_Adapter extends RecyclerView.Adapter<MyHolder> {

    List<Jiugongge_Bean.DataBean> jiugongge_listview;
    Context context;
    private MyHolder myHolder;

    public JiuGongGe_Adapter(List<Jiugongge_Bean.DataBean> jiugongge_listview, Context context) {
        this.jiugongge_listview = jiugongge_listview;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.jiugongge_item,null);
        myHolder = new MyHolder(inflate);


        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        String[] split = jiugongge_listview.get(position).getIcon().split("\\|");
        Glide.with(context).load(split[0]).into((ImageView) holder.jiugongge_img);
//写一个图片点击事件
        myHolder.jiugongge_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, JiuGongGe_item_Activity.class);
//                deatilurl1相当于一个暗号
                intent.putExtra("deatilurl1",jiugongge_listview.get(position).getIcon());
                context.startActivity(intent);
            }
        });
        holder.jiugongge_text.setText(jiugongge_listview.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return jiugongge_listview.size();
    }
}
