package com.example.mvp_jingdong.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.custom.MySearchView;
import com.example.mvp_jingdong.http.fenlei_bean.You_ListView_Bean;
import com.example.mvp_jingdong.http.fenlei_bean.Zuo_ListView_Bean;
import com.example.mvp_jingdong.mode.Model;
import com.example.mvp_jingdong.mode.adapter.FenLei_You_ListView_Adapter;
import com.example.mvp_jingdong.mode.adapter.FenLei_Zuo_ListView_Adapter;
import com.example.mvp_jingdong.presenter.Presenter;
import com.example.mvp_jingdong.view.FenLei_IMyView;
import com.example.mvp_jingdong.view.activity.FenLei_XiaoXi_Img_Activity;
import com.google.zxing.activity.CaptureActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 石头 on 2018/2/2.
 */

public class Radio_fenlei extends Fragment implements FenLei_IMyView {
    @BindView(R.id.fenlei_img_erweima)
    ImageView fenleiImg_Erweima;
    @BindView(R.id.fenlei_mySearchView)
    MySearchView fenleiMySearchView;
    @BindView(R.id.fenlei_text_sousuo)
    TextView fenleiText_Sousuo;
    @BindView(R.id.fenlei_img_xiaoxi)
    ImageView fenleiImg_Xiaoxi;
    @BindView(R.id.fenlei_zuo_listview)
    ListView fenleiZuo_Listview;
    @BindView(R.id.fenlei_youbian_zhanshi)
    ListView fenleiYoubian_Zhanshi;
    Unbinder unbinder;
    private View view;
    private FenLei_Zuo_ListView_Adapter fenLei_zuo_listView_adapter;
    private final static int REQ_CODE = 1028;
    private List<Zuo_ListView_Bean.DataBean> zuo_listview_listview;
    private Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_fenlei, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter = new Presenter();
        presenter.getfenleiLeft(new Model(presenter), this);
        //            根据 左侧 listview 中item 点击事件
        fenleiZuo_Listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
//            根据 左侧 listview 中item 点击事件
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.getfenleiRight(new Model(presenter), Radio_fenlei.this, i);
            }
        });

        return view;
    }

    //展示左侧listview
    @Override
    public void show_zuoce_listview(List<Zuo_ListView_Bean.DataBean> zuo_listview_listview) {
        this.zuo_listview_listview = zuo_listview_listview;
//        设置默认展示第一个   listview   item
        presenter.getfenleiRight(new Model(presenter), this, 0);
        Log.d("ddd", "左侧---listview-main成功++++++++" + zuo_listview_listview);
        fenLei_zuo_listView_adapter = new FenLei_Zuo_ListView_Adapter(getActivity(), zuo_listview_listview);
        fenleiZuo_Listview.setAdapter(fenLei_zuo_listView_adapter);
    }
    //展示右面   listview
    @Override
    public void show_youce_listview(List<You_ListView_Bean.DataBean> you_listview_listview) {
        Log.d("eee", "main-------右侧--------" + you_listview_listview);
        FenLei_You_ListView_Adapter fenLei_you_listView_adapter = new FenLei_You_ListView_Adapter(getActivity(), you_listview_listview);
        fenleiYoubian_Zhanshi.setAdapter(fenLei_you_listView_adapter);
    }
    //获得下标  根据下标  右边 listview进行更换
    @Override
    public int get_cid(int poristion) {
        int cid = zuo_listview_listview.get(poristion).getCid();
        return cid;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //二维码
    @OnClick({R.id.fenlei_img_erweima, R.id.fenlei_img_xiaoxi})
    public void onViewClicked(View view) {

        switch (view.getId()) {
//            二维码点击事件
            case R.id.fenlei_img_erweima:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;

//                消息  图片点击事件
            case R.id.fenlei_img_xiaoxi:
                startActivity(new Intent(getActivity(), FenLei_XiaoXi_Img_Activity.class));

                break;

        }


    }


}
