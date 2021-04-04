package com.luis.rickmorthy.network.rickandmorthyService

import com.luis.rickmorthy.model.character
import com.luis.rickmorthy.network.model.ResponseApi
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMorthyEndpoints {

    @GET("character")
    fun getCharacters() : Call<ResponseApi<character>>

}