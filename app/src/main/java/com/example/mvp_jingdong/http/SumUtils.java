package com.example.mvp_jingdong.http;

import com.example.mvp_jingdong.http.gouwuche_bean.GouWuChe_Bean;

import java.util.List;

/**
 * Created by lenovo on 2018/3/24.
 */

public class SumUtils {

    public static String sum(List<GouWuChe_Bean.DataBean> list){
        int sum=0;

        for (int i=0;i<list.size();i++){
            List<GouWuChe_Bean.ChildBean> list1 = list.get(i).getList();
            for (int j=0;j<list1.size();j++){
                GouWuChe_Bean.ChildBean childBean = list1.get(j);
                if (childBean.isChildSelectedIsChecked()){
                    sum+=childBean.getPrice()*childBean.getNum();
                }
            }
        }
        return Double.toString(sum);
    }
}
