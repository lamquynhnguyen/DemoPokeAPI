package com.example.demopokeapi

import com.google.gson.annotations.SerializedName

class Pokemon {
    @SerializedName("name")
    var name: String? = null
    @SerializedName("sprites")
    var sprites: Sprites? = null
}

class Sprites {
    @SerializedName("front_default")
    var frontFemale: String? = null
}
