package com.danyglaz.yaduvankinapp.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danyglaz.yaduvankinapp.data.repository.AuthRepository
import com.danyglaz.yaduvankinapp.screen.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
    private val _state = MutableStateFlow(RegisterScreenState())
    val state = _state.asStateFlow()

        fun onEvent(event: RegisterScreenEvent) {
            when (event) {
                is RegisterScreenEvent.EmailUpdated -> onEmailUpdated(event.newEmail)
                is RegisterScreenEvent.PasswordUpdated -> onPasswordUpdated(event.newPassword)
                is RegisterScreenEvent.UsernameUpdated -> onUsernameUpdated(event.newUsername)
                is RegisterScreenEvent.PhoneUpdated -> onPhoneUpdated(event.newPhone)
                is RegisterScreenEvent.SchoolUpdated -> onSchoolNumber(event.newSchool)
                is RegisterScreenEvent.RoleUpdated ->  onRoleNumber(event.newRole)

                is RegisterScreenEvent.ButtonEdit ->when(event.newButtonState) {
                    AuthState.LOGIN -> AuthState.REGISTER
                    AuthState.REGISTER -> AuthState.LOGIN
                }

                is RegisterScreenEvent.RegisterBtnClicked -> register()

            }
        }
    private fun onEmailUpdated(newEmail:String){  _state.update { it.copy(email=newEmail) } }
    private fun onPasswordUpdated(newPassword:String){_state.update { it.copy(password = newPassword) }}
    private fun onUsernameUpdated(newUsername:String){_state.update { it.copy(username = newUsername) }}
    private fun onPhoneUpdated(newPhone:String){_state.update{it.copy(phone = newPhone)}}
    private fun onSchoolNumber(newSchoolNumber: String){_state.update { it.copy(schoolNumber = newSchoolNumber) }}
    private fun onRoleNumber(newRole:String){_state.update { it.copy(role = newRole) }}


    private fun register() = viewModelScope.launch(Dispatchers.IO) {
        val userName = state.value.username
        val email = state.value.email
        val phone = state.value.phone
        val password = state.value.password
        val schoolNumber = state.value.schoolNumber
        val role = state.value.role
        if (userName.isEmpty() || email.isEmpty() ||phone.isEmpty() || password.isEmpty() || schoolNumber.isEmpty() || role.isEmpty()) return@launch
        val result = authRepository.register(userName,email,  password,phone, schoolNumber, role)
        this@RegisterScreenViewModel._state.update { it.copy(registerResult = result) }
    }
}