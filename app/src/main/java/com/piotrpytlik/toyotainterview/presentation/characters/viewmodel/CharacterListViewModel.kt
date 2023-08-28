package com.piotrpytlik.toyotainterview.presentation.characters.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.piotrpytlik.toyotainterview.usecase.characters.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
        private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val innerState = mutableStateOf(CharactersListState(loading = true))
    val state: State<CharactersListState> = innerState

    init {
        getCharacters()
    }

    private fun getCharacters() {
        getCharactersUseCase().onEach { result ->

            when {
                result.isFailure -> {
                    innerState.value = CharactersListState(
                            errorMessage = result.exceptionOrNull()?.localizedMessage ?: "Some unexpected error occured.")
                }
                result.isSuccess -> {
                    innerState.value = CharactersListState(
                            characterList = result.getOrDefault(listOf()), loading = false)
                }
            }


        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}