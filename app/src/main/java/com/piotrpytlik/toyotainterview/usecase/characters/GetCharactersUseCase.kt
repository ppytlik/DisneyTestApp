package com.piotrpytlik.toyotainterview.usecase.characters

import com.piotrpytlik.toyotainterview.domain.model.Character
import com.piotrpytlik.toyotainterview.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
        private val characterRepository: CharacterRepository
) {

    operator fun invoke(): Flow<Result<List<Character>>> = flow {
        try {
            val listOfCharacters = characterRepository.getCharacters()
            listOfCharacters.takeIf { it.isNotEmpty() }?.let {
                emit(Result.success(listOfCharacters))
            } ?: emit(Result.failure(Throwable("Character list was empty.")))
        } catch (e: HttpException) {
            emit(Result.failure(e))
        } catch (e: Throwable) {
            emit(Result.failure(e))
        }
    }
}