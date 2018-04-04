package com.example.mvp_jingdong.view.fragment_faxian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp_jingdong.R;


/**
 * Created by 石头 on 2018/2/2.
 */

public class Faxian_6 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.faxian_6,container,false);
        return view;
    }
}
