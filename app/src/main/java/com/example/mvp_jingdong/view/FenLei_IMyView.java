package com.example.mvp_jingdong.view;

import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.Zuo_ListView_Bean;

import java.util.List;

/**
 * Created by 石头 on 2018/3/29.
 */

public interface FenLei_IMyView {
//    分类界面左侧listview
    void  show_zuoce_listview(List<Zuo_ListView_Bean.DataBean> zuo_listview_listview);

// 分类界面右侧   展示  listview
    void  show_youce_listview(List<You_ListView_Bean.DataBean>  you_listview_listview);
//根据  左侧 下标进行传值
    int get_cid(int poristion);
}
