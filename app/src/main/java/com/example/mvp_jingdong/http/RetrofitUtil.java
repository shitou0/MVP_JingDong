package com.example.mvp_jingdong.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**写一个retrofitutil工具类
 * Created by 石头 on 2018/3/23.
 */

public class RetrofitUtil {
//    单例模式
    private static RetrofitUtil retrofitUtil;
    private final Retrofit retrofit;

    public static RetrofitUtil getInstance(){
        if (retrofitUtil == null){
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }
//        初始化 retorfit
    public RetrofitUtil(){
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.base_url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
    //指定服务
    public <T> T createRequest(Class<T> clz) {
        T t = retrofit.create(clz);
        return t;
    }

}
