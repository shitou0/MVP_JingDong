package com.example.mvp_jingdong.view;

import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;

import java.util.List;

/**  购物车
 * Created by 石头 on 2018/4/1.
 */

public interface GouWu_IMyView {
//展示购物车
    void show_GouWuChe(List<GouWuChe_Bean.DataBean>  gouwuche_listview);
    void showCount(String count);
}
