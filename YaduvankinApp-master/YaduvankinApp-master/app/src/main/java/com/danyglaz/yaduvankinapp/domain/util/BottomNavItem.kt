package com.danyglaz.yaduvankinapp.domain.util

import androidx.compose.ui.graphics.vector.ImageVector
import com.danyglaz.yaduvankinapp.presentation.screen.main.navigation.MainScreenNavigationRoute

data class BottomNavItem(
    val icon: ImageVector,
    val titleResId: Int,
    val route: MainScreenNavigationRoute
)
