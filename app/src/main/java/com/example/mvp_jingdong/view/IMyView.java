package com.example.mvp_jingdong.view;

import com.example.mvp_jingdong.http.shouye_bean.Jiugongge_Bean;
import com.example.mvp_jingdong.http.shouye_bean.KuaiBao_Bean;
import com.example.mvp_jingdong.http.shouye_bean.MeiRiGuang_Bean;

import java.util.List;

/**
 * Created by 石头 on 2018/3/23.
 */

public interface IMyView {
//    展示九宫格
    void show_jiugongge(List<Jiugongge_Bean.DataBean> jiugongge_listview);
//    快报
    void show_kuaibao(List<KuaiBao_Bean.MiaoshaBean.ListBeanX> kuaibao_listview);
//    每日逛
    void show_meiriguang(List<MeiRiGuang_Bean.TuijianBean.ListBean> meiriguang_listview);



}
