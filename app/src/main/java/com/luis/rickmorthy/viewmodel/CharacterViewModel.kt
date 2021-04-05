package com.luis.rickmorthy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luis.rickmorthy.model.character
import com.luis.rickmorthy.network.model.ResponseApi
import com.luis.rickmorthy.network.rickandmorthyService.RickAndMorthyEndpoints
import com.luis.rickmorthy.network.rickandmorthyService.rickandmorthyServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    var listCharacters : MutableLiveData<List<character>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()


    fun refresh(){
        getCharactersFromApi()
    }

    private fun processFinished(){
        isLoading.value = true;
    }

    private fun getCharactersFromApi(){
        val request = rickandmorthyServiceBuilder.buildService(RickAndMorthyEndpoints::class.java)
        val call = request.getCharacters()

        call.enqueue(object : Callback<ResponseApi<character>>{

            override fun onFailure(call: Call<ResponseApi<character>>, t: Throwable) {
                processFinished()
            }

            override fun onResponse(
                call: Call<ResponseApi<character>>,
                response: Response<ResponseApi<character>>
            ) {

                if (response.isSuccessful){
                    val results = response.body()!!.results
                    listCharacters.postValue(results)
                }

                processFinished()
            }

        })
    }
}