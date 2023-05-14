package com.example.latihanmvvmwithnewsapi.model


import com.google.gson.annotations.SerializedName

data class  SourceData(
    @SerializedName("sources")
    val sources: List<Source>,
    @SerializedName("status")
    val status: String
)