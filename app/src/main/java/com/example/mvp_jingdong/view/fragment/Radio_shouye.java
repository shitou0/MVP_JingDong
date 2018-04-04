package com.example.mvp_jingdong.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.custom.MySearchView;
import com.example.mvp_jingdong.http.shouye_bean.Jiugongge_Bean;
import com.example.mvp_jingdong.http.shouye_bean.KuaiBao_Bean;
import com.example.mvp_jingdong.http.shouye_bean.MeiRiGuang_Bean;
import com.example.mvp_jingdong.mode.Model;
import com.example.mvp_jingdong.mode.adapter.JiuGongGe_Adapter;
import com.example.mvp_jingdong.mode.adapter.KuaiBao_Adapter;
import com.example.mvp_jingdong.mode.adapter.MeiRiGuang_Adapter;
import com.example.mvp_jingdong.presenter.Presenter;
import com.example.mvp_jingdong.view.IMyView;
import com.example.mvp_jingdong.view.image.BannerImageLoader;
import com.google.zxing.activity.CaptureActivity;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 石头 on 2018/2/2.
 */

public class Radio_shouye extends Fragment implements IMyView {

    @BindView(R.id.mySearchView)
    MySearchView mySearchView;
    @BindView(R.id.search)
    TextView search;
    Unbinder unbinder;
    @BindView(R.id.shouye_ban)
    Banner shouye_Ban;
    @BindView(R.id.shouye_recycler_jiugongge)
    RecyclerView shouye_R_Jiugongge;
    @BindView(R.id.shouye_recycler_kuaibao)
    RecyclerView shouye_R_Kuaibao;
    @BindView(R.id.shouye_recycler_meiriguang)
    RecyclerView shouye_R_Meiriguang;
    @BindView(R.id.shouye_erweima)
    ImageView shouye_Erweima;
    @BindView(R.id.home_marqueeView)
    MarqueeView paoma_deng;
    private View view;
    private final static int REQ_CODE = 1028;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shouye, container, false);
//        获得控件
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    //    生命周期
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        List<String> banner_list = new ArrayList<>();
//进行放入
        banner_list.add("http://img11.360buyimg.com/cms/jfs/t205/116/522046638/706117/c213d57/538fe4b3Nb8e9dc49.jpg");
        banner_list.add("http://pic105.nipic.com/file/20160728/20494655_100750067000_2.jpg");
        banner_list.add("http://pic71.nipic.com/file/20150626/18312035_012812202000_2.jpg");
        banner_list.add("http://img.zcool.cn/community/013add5779dc220000012e7e96dc60.jpg@900w_1l_2o");
        banner_list.add("http://img12.360buyimg.com/cms/jfs/t202/12/1278693591/68264/8d52e2d2/53a96157N321b98d7.jpg");

        shouye_Ban.setImageLoader(new BannerImageLoader());
        shouye_Ban.setImages(banner_list);
        shouye_Ban.start();
        super.onActivityCreated(savedInstanceState);

        Presenter presenter = new Presenter();
        presenter.getList(new Model(presenter), this);

        final ArrayList<String> names = new ArrayList<>();
        names.add("宠辱不惊");
        names.add("看庭前花开花落");
        names.add("去留无意");
        names.add("望天外云卷云舒");
        names.add("君子不器，来京东满足你所有");
        paoma_deng.startWithList(names);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //扫描二维码
    @OnClick({R.id.shouye_erweima, R.id.search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shouye_erweima:
//扫码
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
            case R.id.search:
                String content = mySearchView.getContent();
                Toast.makeText(getActivity(), content + "***", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //实现imyview  方法   九宫格
    @Override
    public void show_jiugongge(List<Jiugongge_Bean.DataBean> jiugongge_listview) {
        Log.d("aaaaaaa", "九宫格---+++++main成功++++++++" + jiugongge_listview);
//        shouye_R_Jiugongge.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        shouye_R_Jiugongge.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));

        JiuGongGe_Adapter jiuGongGe_adapter = new JiuGongGe_Adapter(jiugongge_listview, getActivity());
        shouye_R_Jiugongge.setAdapter(jiuGongGe_adapter);

    }

    //快报
    @Override
    public void show_kuaibao(List<KuaiBao_Bean.MiaoshaBean.ListBeanX> kuaibao_listview) {
        shouye_R_Kuaibao.setLayoutManager(new LinearLayoutManager(getActivity(), OrientationHelper.HORIZONTAL, false));
        Log.d("aaaaaaa", "+++++main成功+++快报+++++" + kuaibao_listview);
        KuaiBao_Adapter kuaibao_adapter = new KuaiBao_Adapter(kuaibao_listview, getActivity());
        shouye_R_Kuaibao.setAdapter(kuaibao_adapter);

    }

    //每日逛
    @Override
    public void show_meiriguang(List<MeiRiGuang_Bean.TuijianBean.ListBean> meiriguang_listview) {
        shouye_R_Meiriguang.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        Log.d("aaaaaaa", "+++++main成功+++每日逛+++++" + meiriguang_listview);
        MeiRiGuang_Adapter meiRiGuang_adapter1 = new MeiRiGuang_Adapter(getActivity(), meiriguang_listview);
        shouye_R_Meiriguang.setAdapter(meiRiGuang_adapter1);
    }
}
