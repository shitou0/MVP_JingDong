package com.example.mvp_jingdong.mode.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;

import java.util.List;

import retrofit2.http.POST;

/**
 * Created by 石头 on 2018/3/31.
 */

public class FenLei_You_ListView_Adapter extends BaseAdapter {


    private Context context;
    private List<You_ListView_Bean.DataBean> you_listview_listview;

    public FenLei_You_ListView_Adapter(Context context, List<You_ListView_Bean.DataBean> you_listview_listview) {
        this.context = context;
        this.you_listview_listview = you_listview_listview;
    }

    @Override
    public int getCount() {
        return you_listview_listview.size();
    }

    @Override
    public Object getItem(int i) {
        return you_listview_listview.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
//        进行优化
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.fenlei_you_listview_item, null);

            holder.right_fenlei_text = view.findViewById(R.id.right_fenlei_text);
            holder.fenlei_gridview = view.findViewById(R.id.fenlei_gridview);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.right_fenlei_text.setText(you_listview_listview.get(i).getName());
        FenLei_You_GridView_Adapter fenLei_you_gridView_adapter = new FenLei_You_GridView_Adapter(context, you_listview_listview.get(i).getList());
        holder.fenlei_gridview.setAdapter(fenLei_you_gridView_adapter);
        return view;
    }

    //    进行viewHolder优化
    public class ViewHolder {
        TextView right_fenlei_text;
        GridView fenlei_gridview;
    }
}
