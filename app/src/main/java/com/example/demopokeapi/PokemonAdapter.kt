package com.example.demopokeapi

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_each_pokemon.view.*

class PokemonAdapter(val context: Context, var pokemons: ArrayList<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.layout_each_pokemon, viewGroup, false)
        return ViewHolder(context, view)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        viewHolder.bindView(pokemon)
    }

    class ViewHolder(val context: Context, pokemonView: View) :
        RecyclerView.ViewHolder(pokemonView) {
        val txtName = pokemonView.txtNamePokemon
        val imagePoke = pokemonView.imgPokemon

        fun bindView(pokemon: Pokemon) {
            txtName.text = pokemon.name
            Glide.with(context)
                .load(pokemon.sprites!!.frontFemale)
                .centerCrop()
                .into(imagePoke)
        }
    }
}
