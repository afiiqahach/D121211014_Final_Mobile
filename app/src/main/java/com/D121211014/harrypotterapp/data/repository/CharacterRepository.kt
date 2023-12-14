package com.D121211014.harrypotterapp.data.repository

import com.D121211014.harrypotterapp.data.response.GetCharacterResponse
import com.D121211014.harrypotterapp.data.source.remote.ApiService

class CharacterRepository(private val apiService: ApiService) {
    suspend fun getCharacter(): GetCharacterResponse {
        return apiService.getCharacter()
    }
}