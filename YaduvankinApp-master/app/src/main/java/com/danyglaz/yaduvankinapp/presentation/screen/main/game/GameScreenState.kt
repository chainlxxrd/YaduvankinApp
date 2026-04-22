package com.danyglaz.yaduvankinapp.presentation.screen.main.game

import com.danyglaz.yaduvankinapp.domain.model.GameItem

data class GameScreenState(
    val searchQuery: String = "",
    val filteredGame:List<GameItem> = emptyList()
)
