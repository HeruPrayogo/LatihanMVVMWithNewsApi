package com.example.latihanmvvmwithnewsapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanmvvmwithnewsapi.model.Source
import com.example.latihanmvvmwithnewsapi.model.SourceData
import com.example.latihanmvvmwithnewsapi.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(var api : ApiService): ViewModel(){
    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource(): MutableLiveData<List<Source>?> {
        return liveDataSource
    }

    fun callApiSource(category: String){
        api.getAllSources(category).enqueue(object : Callback<SourceData> {
            override fun onResponse(
                call: Call<SourceData>,
                response: Response<SourceData>
            ) {
                if (response.isSuccessful){
                    liveDataSource.postValue(response.body()!!.sources)

                }else{
                    liveDataSource.postValue(null)
                }
            }

            override fun onFailure(call: Call<SourceData>, t: Throwable) {
                liveDataSource.postValue(null)
            }

        })
    }

}
