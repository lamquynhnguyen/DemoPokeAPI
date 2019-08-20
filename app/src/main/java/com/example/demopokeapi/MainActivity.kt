package com.example.demopokeapi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DisplayContract.View {
    private lateinit var displayPresent: DisplayPresent
    private lateinit var pokemonAdapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayPresent = DisplayPresent(this)
        pokemonAdapter = PokemonAdapter(this, displayPresent.pokemons as ArrayList<Pokemon>)
        recyclerListPokemon.adapter = pokemonAdapter
        displayPresent.handleDisplay()
    }

    override fun display() {
        pokemonAdapter.notifyDataSetChanged()
    }
}
