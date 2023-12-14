package com.D121211014.harrypotterapp.data.source.remote

import com.D121211014.harrypotterapp.data.response.GetCharacterResponse
import retrofit2.http.GET

interface ApiService {

    @GET("api/characters/house/:house")
    suspend fun getCharacter(): GetCharacterResponse
}