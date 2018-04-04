package com.example.mvp_jingdong.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.http.SumUtils;
import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;
import com.example.mvp_jingdong.mode.Model;
import com.example.mvp_jingdong.mode.adapter.GouWuChe_Adapter;
import com.example.mvp_jingdong.presenter.Presenter;
import com.example.mvp_jingdong.view.GouWu_IMyView;
import com.example.mvp_jingdong.view.activity.FenLei_XiaoXi_Img_Activity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 石头 on 2018/2/2.
 */

public class Radio_gouwuche extends Fragment implements GouWu_IMyView {


    Unbinder unbinder;
    @BindView(R.id.expand_listview)
    ExpandableListView expandListview;
    @BindView(R.id.gouwuche_checkBox)
    CheckBox gouwuche_CheckBox;
    @BindView(R.id.sum)
    TextView sum;
    @BindView(R.id.gouwuche_qujiesuan_button)
    Button gouwucheQujiesuanButton;
    @BindView(R.id.gouwuche_xiaoxi)
    ImageView gouwucheXiaoxi;
    private View view;
    private List<GouWuChe_Bean.DataBean> gouwuche_listview;
    private GouWuChe_Adapter gouWuChe_adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_gouwuche, container, false);
        Presenter presenter = new Presenter();
        presenter.getGouWuCheList(new Model(presenter), this);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    //    展示数据
    @Override
    public void show_GouWuChe(List<GouWuChe_Bean.DataBean> gouwuche_listview) {
        this.gouwuche_listview = gouwuche_listview;
        Log.d("fff", "-----main-----成功");
//        实例化 适配器
        gouWuChe_adapter = new GouWuChe_Adapter(getActivity(), gouwuche_listview, this);
        expandListview.setAdapter(gouWuChe_adapter);
//        设置默认展示出来
        int groupCount = expandListview.getCount();
        for (int i = 0; i < groupCount; i++) {
            expandListview.expandGroup(i);
        }
        ;
    }

    //展示总价
    @Override
    public void showCount(String count) {
        sum.setText(count);
        SumUtils.sum(gouwuche_listview);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //全选
    @OnClick({R.id.gouwuche_checkBox, R.id.gouwuche_qujiesuan_button,R.id.gouwuche_xiaoxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gouwuche_checkBox:
                boolean checked = gouwuche_CheckBox.isChecked();
                for (int i = 0; i < gouwuche_listview.size(); i++) {
                    GouWuChe_Bean.DataBean dataBean = gouwuche_listview.get(i);
                    dataBean.setParentSelectedIsChecked(checked);

                    //获得子集合  遍历
                    List<GouWuChe_Bean.ChildBean> list4 = dataBean.getList();
                    for (int j = 0; j < list4.size(); j++) {
                        list4.get(j).setChildSelectedIsChecked(checked);
                    }
                }
                gouWuChe_adapter.notifyDataSetChanged();
                String coun = SumUtils.sum(gouwuche_listview);
                sum.setText(coun);
                break;
            case R.id.gouwuche_qujiesuan_button:
                Toast.makeText(getActivity(), "欢迎您进行再次购买", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gouwuche_xiaoxi:
                startActivity(new Intent(getActivity(), FenLei_XiaoXi_Img_Activity.class));
                break;
        }
    }

}
