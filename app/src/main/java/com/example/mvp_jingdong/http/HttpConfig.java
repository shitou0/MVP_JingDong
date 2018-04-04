package com.example.mvp_jingdong.http;

/**
 * Created by 石头 on 2018/3/23.
 */

public class HttpConfig {
    public static String base_url = "https://www.zhaoapi.cn/";

    //首页九宫格
    public static String shouye_JiuGongGe = "product/getCatagory";

    //    京东快报    https://www.zhaoapi.cn/ad/getAd
    public static String shouye_KuaiBao = "ad/getAd";

    //    每日逛    https://www.zhaoapi.cn/ad/getAd
    public static String shouye_MeiRiGuang = "ad/getAd";

    //分类界面 左侧 listview
    public static String fenlei_zuo_listview = "product/getCatagory";

    //    分类界面  右侧  listview
    public static String fenlei_you_listview = "product/getProductCatagory";

    //    购物车 展示   https://www.zhaoapi.cn/product/getCarts?source=android&uid=71
    public static String gouwuche_url = "product/getCarts";


}
