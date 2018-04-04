package com.example.mvp_jingdong.presenter;

import android.util.Log;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 石头 on 2018/3/23.
 */

public class Presenter implements IPresenter {
    private IMyView iMyView;
    private FenLei_IMyView fenLei_iMyView;
    private GouWu_IMyView gouWu_iMyView;

    @Override
    public void getList(IModel iModel, IMyView iMyView) {
        this.iMyView = iMyView;
        Map<String, String> map = new HashMap<>();
        iModel.getJiuGongGe(map);
        iModel.getKuaiBao(map);
        iModel.getMeiRiGuang(map);
    }
    //分类左侧
    @Override
    public void getfenleiLeft(IModel iModel, FenLei_IMyView fenLei_iMyView) {
        this.fenLei_iMyView=fenLei_iMyView;
        Map<String, String> map = new HashMap<>();
        map.put("cid", "2");
        iModel.getFenLei_Zuo_ListView(map);
    }
//    分类右侧
    @Override
    public void getfenleiRight(IModel iModel, FenLei_IMyView fenLei_iMyView, int poistion) {
        this.fenLei_iMyView=fenLei_iMyView;
        Map<String, String> map = new HashMap<>();
        map.put("cid",fenLei_iMyView.get_cid(poistion)+"");
        iModel.getFenLei_You_ListView(map);
    }
//
    //九宫格
    @Override
    public void getListData(List<Jiugongge_Bean.DataBean> jiugongge_listview) {
        Log.d("aaa", "---p层展示九宫格------------------" + jiugongge_listview);
        //        添加参数
//        map.put("uid","71");
        iMyView.show_jiugongge(jiugongge_listview);
    }

    //快报
    @Override
    public void getkuaibao_ListData(List<KuaiBao_Bean.MiaoshaBean.ListBeanX> kuaibao_listview) {
        Log.d("aaa", "---p层展示快报------------------" + kuaibao_listview);
        iMyView.show_kuaibao(kuaibao_listview);
    }

    //每日逛
    @Override
    public void getmeiriguang_ListData(List<MeiRiGuang_Bean.TuijianBean.ListBean> meiribao_listview) {
        Log.d("aaa", "---p层展示每日逛------------------" + meiribao_listview);
        iMyView.show_meiriguang(meiribao_listview);
    }

    //分类界面 左侧 listview
    @Override
    public void getfenleizuolistview_ListData(List<Zuo_ListView_Bean.DataBean> zuo_listview_listview) {
        Log.d("ddd", "---p层展示分类左侧listview-----------------" + zuo_listview_listview);
        fenLei_iMyView.show_zuoce_listview(zuo_listview_listview);
    }

    //分类界面  右侧  listview
    @Override
    public void getfenleiyoulistview_ListData(List<You_ListView_Bean.DataBean> you_listview_listview) {
//                                             List<You_ListView_Bean.DataBean> you_listview_listview
        Log.d("eee", "---p层展示分类右侧listview-----------------" + you_listview_listview);
        fenLei_iMyView.show_youce_listview(you_listview_listview);
    }


//    购物车
    @Override
    public void getGouWuCheList(IModel iModel, GouWu_IMyView gouWu_iMyView) {
        this.gouWu_iMyView = gouWu_iMyView;
        Map<String,String> gouwuche_map = new HashMap<>();
        gouwuche_map.put("uid","71");
        gouwuche_map.put("source","android");
        iModel.getGouWuChe_ListView(gouwuche_map);
    }

    @Override
    public void getgouwuche_ListData(List<GouWuChe_Bean.DataBean> gouwuche_listview) {
                            //        List<GouWuChe_Bean.DataBean> gouwuche_listview

        gouWu_iMyView.show_GouWuChe(gouwuche_listview);
        Log.d("fff", "---p层展示购物车listview-----------------" + gouwuche_listview);

    }


}
