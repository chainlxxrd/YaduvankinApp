package com.danyglaz.yaduvankinapp.screen.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.danyglaz.yaduvankinapp.screen.AuthState

@Composable
fun LoginOrRegistration(loginState: AuthState){
    var  loginState by remember {
        mutableStateOf(AuthState.LOGIN)
    }
    val options = listOf("Вход", "Регистрация")
    // Отслеживание выбранного индекса с помощью состояния
    var selectedIndex by remember { mutableStateOf(0) }

    // Используем SingleChoiceSegmentedButtonRow для создания ряда сегментированных кнопок
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        options.forEachIndexed { index, label ->
            // Применяем SegmentedButton для каждой опции
            SegmentedButton(
                shape = when (index) {
                    // Устанавливаем форму для закругления краев: левый для первой кнопки, правый для последней
                    0 -> SegmentedButtonDefaults.baseShape.copy(topEnd = CornerSize(0.dp), bottomEnd = CornerSize(0.dp))
                    options.size - 1 -> SegmentedButtonDefaults.baseShape.copy(topStart = CornerSize(0.dp), bottomStart = CornerSize(0.dp))
                    else -> CornerSize(0.dp) // Если у вас больше двух кнопок
                } as Shape,
                onClick = { selectedIndex = index
                    loginState = when(loginState){
                        AuthState.LOGIN -> AuthState.REGISTER
                        AuthState.REGISTER -> AuthState.LOGIN
                    }
                          },
                selected = index == selectedIndex,
            ) {
                Text(label)
            }
        }
    }
}