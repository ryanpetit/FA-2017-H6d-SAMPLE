package com.fa17.ssu385.fa_2017_h6d_sample.network;

import com.fa17.ssu385.fa_2017_h6d_sample.network.adapter.RecipeApiAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecipeApi {
    private static RecipeApi api;

    private RecipeApi() {
        api = this;
    }

    final public static RecipeApiAdapter adapter() {
        Gson gson = new GsonBuilder().create();

        final RecipeApiAdapter apiAdapter = new Retrofit.Builder()
                .baseUrl("http://api.yummly.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(RecipeApiAdapter.class);

        return apiAdapter;

    }
}

