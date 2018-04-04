package com.example.mvp_jingdong.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.example.mvp_jingdong.R;
import com.example.mvp_jingdong.view.fragment_faxian.Faxian_1;
import com.example.mvp_jingdong.view.fragment_faxian.Faxian_2;
import com.example.mvp_jingdong.view.fragment_faxian.Faxian_3;
import com.example.mvp_jingdong.view.fragment_faxian.Faxian_4;
import com.example.mvp_jingdong.view.fragment_faxian.Faxian_5;
import com.example.mvp_jingdong.view.fragment_faxian.Faxian_6;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by 石头 on 2018/2/2.
 */

public class Radio_faxian extends Fragment {

    @BindView(R.id.faxian_pager_Sliding)
    PagerSlidingTabStrip faxian_PagerSliding;
    @BindView(R.id.faxian_viewpager)
    ViewPager faxian_Viewpager;
    Unbinder unbinder;
    private View view;
    Fragment fragment = null;

    String[] arr = {"全部", "代付款", "待收货", "已完成", "视频", "直播"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_faxian, container, false);
        unbinder = ButterKnife.bind(this, view);
        faxian_Viewpager.setAdapter(new MyAdapter(getActivity().getSupportFragmentManager()));
        faxian_PagerSliding.setViewPager(faxian_Viewpager);

//        设置下面的横线 高度
        faxian_PagerSliding.setIndicatorHeight(5);
//        设置默认 展示的第一个界面
        faxian_Viewpager.setCurrentItem(1);
        return view;
    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return arr[position];
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {

                case 0:
                    fragment = new Faxian_1();
                    break;

                case 1:

                    fragment = new Faxian_2();
                    break;

                case 2:

                    fragment = new Faxian_3();
                    break;
                case 3:

                    fragment = new Faxian_4();
                    break;
                case 4:

                    fragment = new Faxian_5();
                    break;
                case 5:

                    fragment = new Faxian_6();
                    break;
            }

            return fragment;
        }
        @Override
        public int getCount() {
            return arr.length;
        }}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
