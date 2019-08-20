package com.example.demopokeapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class DisplayPresent(val view: DisplayContract.View) : DisplayContract.Present {
    val pokemons: List<Pokemon> = ArrayList()
    override fun handleDisplay() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpBuilder = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpBuilder)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PokemonService::class.java)
        for (i in START until END) {
            val call = service.getPokemonData(i)
            call.enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if (response.code() == RESPONSE_CODE) {
                        val pokemon = response.body()
                        (pokemons as ArrayList).add(pokemon)
                        view.display()
                    }
                }
            })
        }
    }

    companion object {
        private const val BASE_URL = "https://pokeapi.co"
        private const val START = 1
        private const val END = 100
        private const val RESPONSE_CODE = 200
    }
}
