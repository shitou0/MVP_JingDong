package com.example.mvp_jingdong.mode;

import java.util.Map;

/**
 * Created by 石头 on 2018/3/23.
 */

public interface IModel {
    //    九宫格
    void getJiuGongGe(Map<String, String> jiugongge_map);

    //快报
    void getKuaiBao(Map<String, String> kuaibao_mvp);

//    每日逛
    void getMeiRiGuang(Map<String,String> meiriguang_map);

//    分类界面  左侧  listview
    void getFenLei_Zuo_ListView(Map<String,String> fenlei_zuo_map);

//    分类界面  右侧  listview
    void getFenLei_You_ListView(Map<String ,String> fenlei_you_map);

    void getGouWuChe_ListView(Map<String,String> gouwuche_map);
}
