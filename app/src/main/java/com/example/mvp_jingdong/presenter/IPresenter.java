package com.example.mvp_jingdong.presenter;

import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;
import com.example.mvp_jingdong.http.shouye_bean.Jiugongge_Bean;
import com.example.mvp_jingdong.http.shouye_bean.KuaiBao_Bean;
import com.example.mvp_jingdong.http.shouye_bean.MeiRiGuang_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.Zuo_ListView_Bean;
import com.example.mvp_jingdong.mode.IModel;
import com.example.mvp_jingdong.view.FenLei_IMyView;
import com.example.mvp_jingdong.view.GouWu_IMyView;
import com.example.mvp_jingdong.view.IMyView;

import java.util.List;

/**
 * Created by 石头 on 2018/3/23.
 */

public interface IPresenter {

    //    进行IModel  和   IMyView 连接
    void getList(IModel iModel, IMyView iMyView);
    //左侧分类
    void getfenleiLeft(IModel iModel, FenLei_IMyView fenLei_iMyView);
    //    右侧分类
    void getfenleiRight(IModel iModel, FenLei_IMyView fenLei_iMyView,int poistion);


    //    集合从新获取  然后放进  Model
    void getListData(List<Jiugongge_Bean.DataBean> jiugongge_listview);

    //    快报
    void getkuaibao_ListData(List<KuaiBao_Bean.MiaoshaBean.ListBeanX> kuaibao_listview);

    //    每日报
    void getmeiriguang_ListData(List<MeiRiGuang_Bean.TuijianBean.ListBean> meiribao_listview);

    //分类左侧  listview
    void getfenleizuolistview_ListData(List<Zuo_ListView_Bean.DataBean> zuo_listview_listview);

    //    分类右侧   listview
    void getfenleiyoulistview_ListData(List<You_ListView_Bean.DataBean> you_listview_listview);

    //    购物车
    void getGouWuCheList(IModel iModel, GouWu_IMyView gouWu_iMyView);

    //    购物车
    void getgouwuche_ListData(List<GouWuChe_Bean.DataBean> gouwuche_listview);
}
