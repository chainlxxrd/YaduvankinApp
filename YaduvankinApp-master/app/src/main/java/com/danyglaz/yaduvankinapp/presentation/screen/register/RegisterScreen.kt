package com.danyglaz.yaduvankinapp.presentation.screen.register

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.danyglaz.yaduvankinapp.R
import com.danyglaz.yaduvankinapp.presentation.navigation.Screen
import com.danyglaz.yaduvankinapp.presentation.ui.component.StyledButton
import com.danyglaz.yaduvankinapp.screen.AuthState
import com.danyglaz.yaduvankinapp.util.Result
import androidx.compose.runtime.getValue

@Composable
fun RegisterScreen(
    onNavigateTo: (Screen) -> Unit
){
    val viewModel = hiltViewModel<RegisterScreenViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    LaunchedEffect(state.registerResult) {

        state.registerResult?.let { registerResult ->
            when (registerResult) {
                is Result.Success<*> -> {
                    onNavigateTo(Screen.Main)
                }

                is Result.Failure<*> -> {
                    Toast.makeText(
                        context,
                        registerResult.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
    RegisterView(
        state = state,
        onNavigateTo = onNavigateTo,
        onEvent = viewModel::onEvent
    )
}
@Composable
fun RegisterView(
    onNavigateTo: (Screen) -> Unit = {},
    state: RegisterScreenState = RegisterScreenState(),
    onEvent: (RegisterScreenEvent)->Unit ={}
){
    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.start_text))

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.title_register),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive
            )

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = stringResource(id = R.string.title_register2))

        Spacer(modifier = Modifier.height(20.dp))
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            state.options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = when (index) {
                        0 -> SegmentedButtonDefaults.baseShape.copy(
                            topEnd = CornerSize(0.dp),
                            bottomEnd = CornerSize(0.dp)
                        )

                        state.options.size - 1 -> SegmentedButtonDefaults.baseShape.copy(
                            topStart = CornerSize(0.dp),
                            bottomStart = CornerSize(0.dp)
                        )

                        else -> CornerSize(0.dp)
                    }  as  Shape,
                    onClick = {
                        state.selectedIndex = index
                        onEvent(RegisterScreenEvent.ButtonEdit(AuthState.REGISTER))
                        onNavigateTo(Screen.Login)
                    },
                    selected = index == state.selectedIndex,

                    ) {
                    Text(label)
                }

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.enter_username)) },
            value = state.username,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                onEvent(RegisterScreenEvent.UsernameUpdated(it))
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.enter_email)) },
            value = state.email,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                onEvent(RegisterScreenEvent.EmailUpdated(it))
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.enter_phone)) },
            value = state.phone,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                onEvent(RegisterScreenEvent.PhoneUpdated(it))
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.enter_school)) },
            value = state.schoolNumber,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                onEvent(RegisterScreenEvent.SchoolUpdated(it))
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.enter_password)) },
            value = state.password,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                onEvent(RegisterScreenEvent.PasswordUpdated(it))
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            label = { Text(text = stringResource(id = R.string.enter_role)) },
            value = state.role,
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                onEvent(RegisterScreenEvent.RoleUpdated(it))
            }
        )

        Spacer(modifier = Modifier.height(20.dp))
        StyledButton(
            onClick = {onEvent(RegisterScreenEvent.RegisterBtnClicked)} ,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = stringResource(id = R.string.register)
            )
        }

        
    }
}

