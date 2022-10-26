package com.example.rickandmorty.model

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("results")
    val personajes: List<Characters>
)
