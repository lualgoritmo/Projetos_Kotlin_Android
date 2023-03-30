package br.com.zup.desafirickmorth.data.model


import com.google.gson.annotations.SerializedName

data class RickAndMortyResponse(
    @SerializedName("results")
    val results: List<PersonResult>
)