package com.danyglaz.yaduvankinapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class GameItemDto(
    @SerialName("gameId")
    val id: String?,
    @SerialName("ownerId")
    val ownerId: Int, // Сервер присылает число
    @SerialName("titleGame")
    val title: String?,
    @SerialName("descriptionGame")
    val description: String?,
    val type: String?

//    val id: String?,
//    val ownerId: String,
//    val title:String?,
//    val description:String?,
//    val type:String?
)


@Serializable
data class SourceDto(
val id:String?,
    val name:String?
)
