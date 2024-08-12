package com.example.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FirstApiService {
    @GET("people/{id}")
    Call<SWModel> getFirstData();

    @GET("people/{id}")
    Call<SWModel> getCharacter(@Path("id") int id);
}