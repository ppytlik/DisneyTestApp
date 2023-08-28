package com.piotrpytlik.toyotainterview.domain.repository

import com.piotrpytlik.toyotainterview.domain.model.Character

interface CharacterRepository {

    suspend fun getCharacters(): List<Character>

}