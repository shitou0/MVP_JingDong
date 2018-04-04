package com.example.mvp_jingdong.mode;

import android.util.Log;

import com.example.mvp_jingdong.http.RetrofitUtil;
import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;
import com.example.mvp_jingdong.http.shouye_bean.Jiugongge_Bean;
import com.example.mvp_jingdong.http.shouye_bean.KuaiBao_Bean;
import com.example.mvp_jingdong.http.shouye_bean.MeiRiGuang_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.Zuo_ListView_Bean;
import com.example.mvp_jingdong.presenter.IPresenter;

import java.util.Map;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 网络获取注释
 * Created by 石头 on 2018/3/23.
 */

public class Model implements IModel {
    //获取p层数据
//    不要忘记下面  完成后  iPresenter.getListData(jiugongge_bean.getData()); 这一行代码
    private final IPresenter iPresenter;

    public Model(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }

    //九宫格
    @Override
    public void getJiuGongGe(Map<String, String> jiugongge_map) {
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<Jiugongge_Bean> jiuGongGe = myService.getJiuGongGe(jiugongge_map);

        jiuGongGe.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())//  observeOn  被观察者
                .subscribe(new Observer<Jiugongge_Bean>() {// subscribe  订阅   Observer观察者
                    @Override
                    public void onCompleted() {
                        Log.d("BookModel", "九宫格---完成----------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BookModel", "九宫格---失败----------");

                    }

                    @Override
                    public void onNext(Jiugongge_Bean jiugongge_bean) {
                        Log.d("BookModel", "九宫格---完成----------");

//                        一定要连接
                        iPresenter.getListData(jiugongge_bean.getData());
                    }
                });
    }

    //快报
    @Override
    public void getKuaiBao(final Map<String, String> kuaibao_mvp) {
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<KuaiBao_Bean> kuaibao = myService.getKuaiBao(kuaibao_mvp);
        kuaibao.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KuaiBao_Bean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("bbbbb", "快报-------完成----------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("bbbbb", e.getMessage() + "快报-------失败----------");
                    }

                    @Override
                    public void onNext(KuaiBao_Bean kuaiBao_bean) {
                        Log.d("bbbbbb", "快报---------完成----------");
                        iPresenter.getkuaibao_ListData(kuaiBao_bean.getMiaosha().getList());
                    }
                });
    }

    //每日逛
    @Override
    public void getMeiRiGuang(Map<String, String> meiriguang_map) {

        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<MeiRiGuang_Bean> meiriguang = myService.getMeiRiGuang(meiriguang_map);
        meiriguang.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MeiRiGuang_Bean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ccc", "model每日逛-------完成----------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ccc", "model每日逛每日逛-------失败----------");
                    }

                    @Override
                    public void onNext(MeiRiGuang_Bean meiRiGuang_bean) {
                        Log.d("ccc", "model每日逛每日逛-------完成----------");
                        iPresenter.getmeiriguang_ListData(meiRiGuang_bean.getTuijian().getList());
                    }
                });
    }

    //分类  左侧  listview
    @Override
    public void getFenLei_Zuo_ListView(Map<String, String> fenlei_zuo_map) {

        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<Zuo_ListView_Bean> fenlei_zuo_listView = myService.getFenlei_Zuo_ListView(fenlei_zuo_map);
        fenlei_zuo_listView.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Zuo_ListView_Bean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("ddd", "model------成功--------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ddd", "model------失败-----" + e.getMessage());
                    }

                    @Override
                    public void onNext(Zuo_ListView_Bean zuo_listView_bean) {
                        Log.d("ddd", "model------正在执行--------");
                        String code = zuo_listView_bean.getCode();
                        if (code.equals("0")) {
                            iPresenter.getfenleizuolistview_ListData(zuo_listView_bean.getData());
                        }
                    }
                });
    }

    //分类界面  右侧  listview
    @Override
    public void getFenLei_You_ListView(Map<String, String> fenlei_you_map) {
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<You_ListView_Bean> fenLei_you_listView = myService.getFenLei_You_ListView(fenlei_you_map);
        fenLei_you_listView.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<You_ListView_Bean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("eee", "---model--------成功------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("eee", "---model--------失败------" + e.getMessage());
                    }
                    @Override
                    public void onNext(You_ListView_Bean you_listView_bean) {
                        Log.d("eee", "---model--------正在执行------");
                        iPresenter.getfenleiyoulistview_ListData(you_listView_bean.getData());
                    }
                });
    }

    //购物车
    @Override
    public void getGouWuChe_ListView(Map<String, String> gouwuche_map) {
        RetrofitUtil retrofitUtil = RetrofitUtil.getInstance();
        MyService myService = retrofitUtil.createRequest(MyService.class);
        Observable<GouWuChe_Bean> gouWuChe_listView = myService.getGouWuChe_ListView(gouwuche_map);
        gouWuChe_listView.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Observer<GouWuChe_Bean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("fff", "---model--------成功------");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fff", "---model--------失败------"+e.getMessage());
                    }

                    @Override
                    public void onNext(GouWuChe_Bean gouWuChe_bean) {
                        Log.d("fff", "---model--------正在执行------");
//                        iPresenter.getGouWuCheList(gouWuChe_bean.getData());
                        iPresenter.getgouwuche_ListData(gouWuChe_bean.getData());
                    }
                });
    }
}
