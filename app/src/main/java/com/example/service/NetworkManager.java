package com.example.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static Retrofit retrofitFirstApi;
    private static FirstApiService firstApiService;

    private static Retrofit retrofitSecondApi;
    private static SecondApiService secondApiService;

       public static FirstApiService getFirstApiService() {
        if (retrofitFirstApi == null) {
            retrofitFirstApi = new Retrofit.Builder()
                    .baseUrl("https://swapi.dev/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            firstApiService = retrofitFirstApi.create(FirstApiService.class);
        }
        return firstApiService;
    }


    public static SecondApiService getSecondApiService() {
        if (retrofitSecondApi == null) {
            retrofitSecondApi = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            secondApiService = retrofitSecondApi.create(SecondApiService.class);
        }
        return secondApiService;
    }
}
