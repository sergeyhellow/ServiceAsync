package com.example.service;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textViewCharacterInfo;
    private TextView textViewPostInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCharacterInfo = findViewById(R.id.textViewCharacterInfo);
        textViewPostInfo = findViewById(R.id.textViewPostInfo);

        loadCharacterInfo();
        loadPostInfo();
    }

    private void loadCharacterInfo() {
        FirstApiService apiService = NetworkManager.getFirstApiService();
        Call<SWModel> call = apiService.getCharacter(1); //

        call.enqueue(new Callback<SWModel>() {
            @Override
            public void onResponse(Call<SWModel> call, Response<SWModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    SWModel character = response.body();
                    textViewCharacterInfo.setText("Имя: " + character.getName() + ", Рост: " + character.getHeight() + ", Вес: " + character.getMass());
                } else {
                    textViewCharacterInfo.setText("Ошибка при загрузке информации о персонаже");
                }
            }

            @Override
            public void onFailure(Call<SWModel> call, Throwable t) {
                textViewCharacterInfo.setText("Ошибка при загрузке информации о персонаже: " + t.getMessage());
            }
        });
    }

    private void loadPostInfo() {
        SecondApiService apiService = NetworkManager.getSecondApiService();
        Call<List<PostModel>> call = apiService.getPosts();

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<PostModel> posts = response.body();
                    if (!posts.isEmpty()) {
                        PostModel post = posts.get(0);
                        textViewPostInfo.setText("Slug: " + post.getSlug() + ", Title: " + post.getTitle());
                    }
                } else {
                    textViewPostInfo.setText("Ошибка при загрузке информации о посте");
                }
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                textViewPostInfo.setText("Ошибка при загрузке информации о посте: " + t.getMessage());
            }
        });
    }
}