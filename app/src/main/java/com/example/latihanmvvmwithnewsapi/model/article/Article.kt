package com.example.latihanmvvmwithnewsapi.model.article


import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("articles")
    val articles: List<ArticleX>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)