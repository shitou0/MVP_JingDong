package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.fenlei_bean.Zuo_ListView_Bean;

import java.util.List;

/**
 * Created by 石头 on 2018/3/29.
 */

public class FenLei_Zuo_ListView_Adapter extends BaseAdapter {

    Context context;
    List<Zuo_ListView_Bean.DataBean> fenlei_zuo_list;

    public FenLei_Zuo_ListView_Adapter(Context context, List<Zuo_ListView_Bean.DataBean> fenlei_zuo_list) {
        this.context = context;
        this.fenlei_zuo_list = fenlei_zuo_list;
    }

    @Override
    public int getCount() {
        return fenlei_zuo_list.size();
    }

    @Override
    public Object getItem(int i) {
        return fenlei_zuo_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
//        进行优化
        if (view == null){
            holder = new ViewHolder();
            view= View.inflate(context, R.layout.fenlei_zuo_listview_item,null);
            holder.fenlei_zuo_listview_item = view.findViewById(R.id.fenlei_zuo_listview_item);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.fenlei_zuo_listview_item.setText(fenlei_zuo_list.get(i).getName());
        return view;
    }
    //    进行viewHolder优化
    public class ViewHolder{
        TextView fenlei_zuo_listview_item;
    }
}
