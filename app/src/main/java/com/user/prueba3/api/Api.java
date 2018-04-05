package com.user.prueba3.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private final static String URL = "https://nicaraguan-foods.herokuapp.com/api/";

    public static ApiInterface instance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }
}
