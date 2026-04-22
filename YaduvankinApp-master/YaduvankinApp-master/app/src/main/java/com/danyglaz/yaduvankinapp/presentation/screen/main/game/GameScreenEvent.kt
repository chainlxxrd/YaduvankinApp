package com.danyglaz.yaduvankinapp.presentation.screen.main.game

import com.danyglaz.yaduvankinapp.domain.model.GameItem

sealed interface GameScreenEvent {
    data class SearchQueryChange(val gameSearchQuery: String): GameScreenEvent
    data class GameItemClicked(val gameItem: GameItem): GameScreenEvent
    data class GameItemNeedClicked(val gameItem: GameItem): GameScreenEvent
}