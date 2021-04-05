package com.luis.rickmorthy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luis.rickmorthy.model.episode
import com.luis.rickmorthy.network.model.ResponseApi
import com.luis.rickmorthy.network.rickandmorthyService.RickAndMorthyEndpoints
import com.luis.rickmorthy.network.rickandmorthyService.rickandmorthyServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {
    var listEpisodes : MutableLiveData<List<episode>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    private  fun processFinished(){
        isLoading.value = true
    }

    fun refresh(){
        getEpisodesFromApi()
    }

    private  fun getEpisodesFromApi(){
        val request = rickandmorthyServiceBuilder.buildService(RickAndMorthyEndpoints::class.java)
        val call = request.getEpisodes()

        call.enqueue(object : Callback<ResponseApi<episode>>{

            override fun onFailure(call: Call<ResponseApi<episode>>, t: Throwable) {
                processFinished()
            }

            override fun onResponse(
                call: Call<ResponseApi<episode>>,
                response: Response<ResponseApi<episode>>
            ) {
                if (response.isSuccessful){
                    val results = response.body()!!.results
                    listEpisodes.postValue(results)
                }

                processFinished()
            }

        })
    }
}