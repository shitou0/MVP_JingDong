package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.shouye_bean.MeiRiGuang_Bean;
import com.example.mvp_jingdong.view.activity.MeiRiGuang_item_Activity;

import java.util.List;

/**
 * Created by 石头 on 2018/3/23.
 */

public class MeiRiGuang_Adapter extends RecyclerView.Adapter<MeiRiGuang_Adapter.MyHolder_MeiRiGuang1> {
    Context context;
    List<MeiRiGuang_Bean.TuijianBean.ListBean> meiriguang_list;

    public MeiRiGuang_Adapter(Context context, List<MeiRiGuang_Bean.TuijianBean.ListBean> meiriguang_list) {
        this.context = context;
        this.meiriguang_list = meiriguang_list;
    }

    private MyHolder_MeiRiGuang1 myHolder_meiRiGuang1;

    @Override
    public MyHolder_MeiRiGuang1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.meiriguang_item, null);
        myHolder_meiRiGuang1 = new MyHolder_MeiRiGuang1(inflate);
        return myHolder_meiRiGuang1;
    }

    @Override
    public void onBindViewHolder(MyHolder_MeiRiGuang1 holder, final int position) {
        String[] split = meiriguang_list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into((ImageView) holder.meiriguang_image);
//        给图片设置点击事件
        myHolder_meiRiGuang1.meiriguang_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MeiRiGuang_item_Activity.class);
                intent.putExtra("deatilurl", meiriguang_list.get(position).getDetailUrl());
                context.startActivity(intent);
            }
        });
        holder.meiriguang_text.setText(meiriguang_list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return meiriguang_list.size();
    }

    //    MyHolder_MeiRiGuang1类
    class MyHolder_MeiRiGuang1 extends RecyclerView.ViewHolder {
        private final TextView meiriguang_text;
        private final ImageView meiriguang_image;

        public MyHolder_MeiRiGuang1(View itemView) {
            super(itemView);
            meiriguang_image = itemView.findViewById(R.id.meiriguang_image);
            meiriguang_text = itemView.findViewById(R.id.meiriguang_text);
        }
    }
}
