package com.example.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SecondApiService {
    @GET("posts")
    Call<PostModel> getSecondData();

    @GET("posts")
    Call<List<PostModel>> getPosts();
}
