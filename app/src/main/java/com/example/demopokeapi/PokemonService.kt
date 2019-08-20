package com.example.demopokeapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("api/v2/pokemon/{id}")
    fun getPokemonData(@Path("id") id: Int): Call<Pokemon>
}
