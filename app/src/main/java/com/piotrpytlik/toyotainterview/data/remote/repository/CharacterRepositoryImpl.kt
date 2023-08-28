package com.piotrpytlik.toyotainterview.data.remote.repository

import com.piotrpytlik.toyotainterview.data.remote.api.CharacterApi
import com.piotrpytlik.toyotainterview.data.remote.dto.toDomainCharacter
import com.piotrpytlik.toyotainterview.domain.model.Character
import com.piotrpytlik.toyotainterview.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
        private val api: CharacterApi
): CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return api.getCharacters().data.map { it.toDomainCharacter() }
    }
}