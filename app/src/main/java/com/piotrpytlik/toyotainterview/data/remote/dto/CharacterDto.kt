package com.piotrpytlik.toyotainterview.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.piotrpytlik.toyotainterview.domain.model.Character

data class CharacterDto(
        @SerializedName("__v")
        val v: Int,
        @SerializedName("_id")
        val id: Int,
        val allies: List<Any>,
        val createdAt: String,
        val enemies: List<Any>,
        val films: List<Any>,
        val imageUrl: String,
        val name: String,
        val parkAttractions: List<Any>,
        val shortFilms: List<Any>,
        val sourceUrl: String,
        val tvShows: List<Any>,
        val updatedAt: String,
        val url: String,
        val videoGames: List<Any>
)

fun CharacterDto.toDomainCharacter(): Character {
        return Character(
                name = name,
                imageUrl = imageUrl
        )
}