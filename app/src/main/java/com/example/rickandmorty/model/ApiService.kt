package com.example.rickandmorty.model

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
   suspend fun getCharacter(): Response<Results>

}