package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.shouye_bean.KuaiBao_Bean;
import com.example.mvp_jingdong.view.activity.KuaiBao_item_Activity;
import com.example.mvp_jingdong.view.activity.MyHolder_KuaiBao;

import java.util.List;

/**快报适配器
 * Created by 石头 on 2018/3/26.
 */

public class KuaiBao_Adapter extends RecyclerView.Adapter<MyHolder_KuaiBao> {
    List<KuaiBao_Bean.MiaoshaBean.ListBeanX> kuaibao_listview;
    Context context;
    private MyHolder_KuaiBao myHolder_kuaiBao;

    public KuaiBao_Adapter(List<KuaiBao_Bean.MiaoshaBean.ListBeanX> kuaibao_listview, Context context) {
        this.kuaibao_listview = kuaibao_listview;
        this.context = context;
    }

    @Override
    public MyHolder_KuaiBao onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.kuaibao_item,null);
        myHolder_kuaiBao = new MyHolder_KuaiBao(inflate);


        return myHolder_kuaiBao;
    }

    @Override
    public void onBindViewHolder(MyHolder_KuaiBao kuaibao_holder, final int position) {
        String[] split = kuaibao_listview.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(kuaibao_holder.kuaibao_img);
        //        item点击事件
        myHolder_kuaiBao.kuaibao_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                进行跳转
                Intent intent = new Intent(context, KuaiBao_item_Activity.class);
                //deatilurl       相当于一个暗号
//                getDetailUrl   指的是跳转WebView
                intent.putExtra("deatilurl",kuaibao_listview.get(position).getDetailUrl());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return kuaibao_listview.size();
    }

}
