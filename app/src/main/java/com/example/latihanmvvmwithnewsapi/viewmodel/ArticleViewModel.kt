package com.example.latihanmvvmwithnewsapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanmvvmwithnewsapi.model.article.Article
import com.example.latihanmvvmwithnewsapi.model.article.ArticleX
import com.example.latihanmvvmwithnewsapi.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ArticleViewModel @Inject constructor(var api : ApiService): ViewModel() {
    lateinit var liveDataArticle : MutableLiveData<List<ArticleX>?>

    init {
        liveDataArticle = MutableLiveData()
    }

    fun getDataArticle() : MutableLiveData<List<ArticleX>?> {
        return liveDataArticle
    }

    fun callApiArticle(article : String) {
        api.gellAllArticles(article).enqueue(object : Callback<Article> {
            override fun onResponse(
                call: Call<Article>,
                response: Response<Article>
            ) {

                if (response.isSuccessful) {
                    liveDataArticle.postValue(response.body()!!.articles)
                } else {
                    liveDataArticle.postValue(null)
                }


            }

            override fun onFailure(call: Call<Article>, t: Throwable) {

                liveDataArticle.postValue(null)

            }

        })

    }

}
