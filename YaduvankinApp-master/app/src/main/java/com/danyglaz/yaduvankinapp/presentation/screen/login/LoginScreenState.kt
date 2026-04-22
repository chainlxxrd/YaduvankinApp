package com.danyglaz.yaduvankinapp.presentation.screen.login

import com.danyglaz.yaduvankinapp.screen.AuthState
import com.danyglaz.yaduvankinapp.util.Result


sealed class LoginScreenEvent{
    data class EmailUpdated(val newEmail:String): LoginScreenEvent()
    data class PasswordUpdated(val newPassword:String): LoginScreenEvent()
    data class ButtonEdit(val newButtonState: AuthState): LoginScreenEvent()
    data object LoginBtnClicked : LoginScreenEvent()
}


data class LoginScreenState(

    val email: String = "",
    val password: String = "",
    val options: List<String> = listOf("Вход", "Регистрация"),
    var selectedIndex: Int = 0,
    val loginState: AuthState = AuthState.LOGIN,

    var loginResult: Result? = null,

    )

