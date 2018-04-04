package com.example.mvp_jingdong.mode;

import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;
import com.example.mvp_jingdong.http.shouye_bean.Jiugongge_Bean;
import com.example.mvp_jingdong.http.shouye_bean.KuaiBao_Bean;
import com.example.mvp_jingdong.http.shouye_bean.MeiRiGuang_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.Zuo_ListView_Bean;


import java.util.Map;

import retrofit2.http.HTTP;
import retrofit2.http.QueryMap;
import rx.Observable;

/**  拼接网络接口
 * Created by 石头 on 2018/3/23.
 */

public interface MyService {
    //    九宫格
    @HTTP(method = "GET", path = "product/getCatagory")
    Observable<Jiugongge_Bean> getJiuGongGe(@QueryMap Map<String, String> jiugongge_map);

    //快报
    @HTTP(method = "GET", path = "ad/getAd")
    Observable<KuaiBao_Bean> getKuaiBao(@QueryMap Map<String, String> kuaibao_mvp);

    //每日逛
    @HTTP(method = "GET", path = "ad/getAd")
    Observable<MeiRiGuang_Bean> getMeiRiGuang(@QueryMap Map<String,String> meiriguang_map);

//    分类左侧listview
    @HTTP(method =  "GET",path = "product/getCatagory")
    Observable<Zuo_ListView_Bean> getFenlei_Zuo_ListView(@QueryMap Map<String,String> fenlei_zuo_listview_map);

//    分类右侧 listview
    @HTTP(method = "GET",path = "product/getProductCatagory")
    Observable<You_ListView_Bean> getFenLei_You_ListView(@QueryMap Map<String,String> fenlei_you_listview_map);

    //    购物车
    @HTTP(method = "GET",path = "product/getCarts")
    Observable<GouWuChe_Bean> getGouWuChe_ListView(@QueryMap Map<String,String> gouwuche_map);

}
