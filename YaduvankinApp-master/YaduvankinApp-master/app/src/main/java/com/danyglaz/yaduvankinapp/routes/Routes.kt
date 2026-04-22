package com.danyglaz.yaduvankinapp.routes

sealed class Routes(val route: String) {
    object Login: Routes("Login")
}