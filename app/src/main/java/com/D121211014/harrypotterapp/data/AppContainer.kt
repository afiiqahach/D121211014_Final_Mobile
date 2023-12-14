package com.D121211014.harrypotterapp.data

import com.D121211014.harrypotterapp.data.repository.CharacterRepository
import com.D121211014.harrypotterapp.data.source.remote.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val characterRepository: CharacterRepository
}

class DefaultAppContainer: AppContainer{
    private val BASE_URL = "https://hp-api.onrender.com"

    val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val characterRepository: CharacterRepository
        get() = CharacterRepository(retrofitService)
}