package com.example.testbook.Model.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.testbook.Helpers.Constants.BASE_URL;

public class NetworkAdapter {


    private static final Object LOCK = new Object();
    private static volatile Retrofit sInstance;

    public static Retrofit getRetrofitInstance() {
        if (sInstance == null) {
            sInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sInstance;
    }
}

