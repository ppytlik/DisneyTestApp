package com.piotrpytlik.toyotainterview.data.remote.api

import com.piotrpytlik.toyotainterview.data.remote.dto.CharacterDto
import com.piotrpytlik.toyotainterview.data.remote.dto.CharacterWrapperDto
import retrofit2.http.GET

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters(): CharacterWrapperDto
}