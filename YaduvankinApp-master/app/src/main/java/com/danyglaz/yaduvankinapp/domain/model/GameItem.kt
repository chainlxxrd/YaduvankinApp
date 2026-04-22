package com.danyglaz.yaduvankinapp.domain.model

data class GameItem(
    val id: String,
    val ownerId:Int,
    val title: String,
    val description: String,
    val type: String,
    val isNeedGame: Boolean,
)
