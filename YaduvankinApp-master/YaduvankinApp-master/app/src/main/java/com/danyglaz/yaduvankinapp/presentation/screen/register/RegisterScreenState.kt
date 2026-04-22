package com.danyglaz.yaduvankinapp.presentation.screen.register

import com.danyglaz.yaduvankinapp.screen.AuthState
import com.danyglaz.yaduvankinapp.util.Result

sealed class RegisterScreenEvent{
    data class UsernameUpdated(val newUsername: String): RegisterScreenEvent()
    data class EmailUpdated(val newEmail:String): RegisterScreenEvent()
    data class PhoneUpdated(val newPhone: String): RegisterScreenEvent()
    data class SchoolUpdated(val newSchool: String): RegisterScreenEvent()
    data class RoleUpdated(val newRole: String): RegisterScreenEvent()
    data class PasswordUpdated(val newPassword:String): RegisterScreenEvent()
    data class ButtonEdit(val newButtonState: AuthState): RegisterScreenEvent()
    data object RegisterBtnClicked: RegisterScreenEvent()
}


data class RegisterScreenState(
    val username: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val schoolNumber: String = "",
    val role: String = "",
    val options: List<String> = listOf("Вход", "Регистрация"),
    var selectedIndex: Int = 1,
    val loginState: AuthState = AuthState.LOGIN,
    val registerResult: Result? = null
)