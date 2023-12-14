package com.D121211014.harrypotterapp.data.response

import com.D121211014.harrypotterapp.data.models.Character
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//class GetCharacterResponse : ArrayList<Character>()

@Serializable
data class GetCharacterResponse(
    @SerialName("data")
    val data: List<Character>,
    @SerialName("message")
    val message: String
)