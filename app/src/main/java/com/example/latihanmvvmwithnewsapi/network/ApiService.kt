package com.example.latihanmvvmwithnewsapi.network

import com.example.latihanmvvmwithnewsapi.model.SourceData
import com.example.latihanmvvmwithnewsapi.model.article.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apikey") apikey : String = "07c252d0ca984cc292b326e3aedf40e0"
    ) : Call<SourceData>

    @GET("top-headlines")
    fun gellAllArticles(
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = "07c252d0ca984cc292b326e3aedf40e0"
    ) : Call<Article>
}