package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<NewsModel> getallnews(@Url String url);

    @GET
    Call<NewsModel> getcategories(@Url String url);
}
