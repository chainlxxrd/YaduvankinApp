package com.danyglaz.yaduvankinapp.presentation.screen.main.navigation

import kotlinx.serialization.Serializable

sealed interface MainScreenNavigationRoute{
    @Serializable
    data object Game: MainScreenNavigationRoute

    @Serializable
    data object Profile: MainScreenNavigationRoute
}