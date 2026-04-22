package com.danyglaz.yaduvankinapp.presentation.screen.main

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSliderState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.danyglaz.yaduvankinapp.presentation.navigation.Screen
import com.danyglaz.yaduvankinapp.presentation.screen.main.game.GameScreen
import com.danyglaz.yaduvankinapp.presentation.screen.main.navigation.BottomNavigationBar
import com.danyglaz.yaduvankinapp.presentation.screen.main.navigation.MainScreenNavigationRoute
import com.danyglaz.yaduvankinapp.presentation.screen.main.profile.ProfileScreen

@Composable
fun MainScreen(

    onNavigateTo: (Screen) -> Unit
){
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ){
        NavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            startDestination = MainScreenNavigationRoute.Game

        ){
           composable<MainScreenNavigationRoute.Game>{
               GameScreen(navigate = {
                   navController.navigate(it)
               })
           }
            composable<MainScreenNavigationRoute.Profile> {
                ProfileScreen()
            }
        }
    }

}
