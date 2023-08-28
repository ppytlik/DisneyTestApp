package com.piotrpytlik.toyotainterview.presentation.characters.viewmodel

import com.piotrpytlik.toyotainterview.domain.model.Character

data class CharactersListState(
        val characterList: List<Character> = listOf(),
        val loading: Boolean = false,
        val errorMessage: String = ""
)
