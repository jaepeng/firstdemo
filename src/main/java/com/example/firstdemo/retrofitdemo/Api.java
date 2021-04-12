package com.example.firstdemo.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("search/recommend")
    Call<SearchRcommend> getRecommendWords();

    @GET("search")
    Call<SearchResult> doSearch(@Query("page")int page, @Query("keyword")String keyword);
}
