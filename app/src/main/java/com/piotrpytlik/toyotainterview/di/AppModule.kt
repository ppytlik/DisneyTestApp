package com.piotrpytlik.toyotainterview.di

import com.piotrpytlik.toyotainterview.data.remote.api.CharacterApi
import com.piotrpytlik.toyotainterview.data.remote.repository.CharacterRepositoryImpl
import com.piotrpytlik.toyotainterview.domain.repository.CharacterRepository
import com.piotrpytlik.toyotainterview.presentation.characters.viewmodel.CharacterListViewModel
import com.piotrpytlik.toyotainterview.usecase.characters.GetCharactersUseCase
import com.piotrpytlik.toyotainterview.util.Extras
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun retrofitInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Extras.BASE_CHAR_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }).build())
                .build()
    }

    @Provides
    @Singleton
    fun characterApi(): CharacterApi {
        return retrofitInstance().create(CharacterApi::class.java)
    }

    @Provides
    @Singleton
    fun characterRepository(): CharacterRepository {
        return CharacterRepositoryImpl(characterApi())
    }

    @Provides
    @Singleton
    fun getCharactersUseCse(): GetCharactersUseCase {
        return GetCharactersUseCase(characterRepository())
    }
}