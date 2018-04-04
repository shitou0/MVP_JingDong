package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;

import java.util.List;

/**
 * Created by 石头 on 2018/3/31.
 */

public class FenLei_You_GridView_Adapter extends BaseAdapter {
    Context context;
    List<You_ListView_Bean.DataBean.ListBean> list;

    public FenLei_You_GridView_Adapter(Context context, List<You_ListView_Bean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {ViewHolder holder;
//        进行优化
        if (view == null){
            holder = new ViewHolder();
            view= View.inflate(context, R.layout.fenlei_you_gradeview_item,null);

            holder.fenlei_you_gradeview_img = view.findViewById(R.id.fenlei_you_gradeview_img);
            holder.fenlei_yuo_gradeview_text = view.findViewById(R.id.fenlei_yuo_gradeview_text);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        String[] split = list.get(i).getIcon().split("\\|");
        Glide.with(context).load(split[0]).into(holder.fenlei_you_gradeview_img);

        holder.fenlei_yuo_gradeview_text.setText(list.get(i).getName());

        return view;
    }
    //    进行viewHolder优化
    public class ViewHolder{
        ImageView fenlei_you_gradeview_img;
        TextView fenlei_yuo_gradeview_text;
    }
}
