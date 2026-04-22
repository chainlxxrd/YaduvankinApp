package com.danyglaz.yaduvankinapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.danyglaz.yaduvankinapp.screen.button.Input
import com.danyglaz.yaduvankinapp.presentation.ui.theme.Grey


/*@Composable
fun LoginPage(navController: NavController){
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val username = remember { mutableStateOf(TextFieldValue()) }
        val phone = remember { mutableStateOf(TextFieldValue()) }
        val schoolNumber = remember { mutableStateOf(TextFieldValue()) }
        val role = remember { mutableStateOf(TextFieldValue()) }
        val email = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        Text( text = "Платформа школьных киберспортивных турниров", style = androidx.compose.ui.text.TextStyle(color = Grey))

        //LoginOrRegistration()
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

        if (loginState == AuthState.LOGIN){
            Text(text = "Вход в систему", style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive))
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Введите свои данные для входа ")


        } else{
            Text(text = "Регистрация в систему", style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Cursive))
            Text(text = "Введите свои данные для регистрации ")
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Имя пользователя") },
                value = username.value,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { username.value = it })
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Номер телефона") },
                value = phone.value,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { phone.value = it })
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                label = { Text(text = "Номер школы") },
                value = schoolNumber.value,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { schoolNumber.value = it })
            TextField(
                label = { Text(text = "Роль в проекте") },
                value = role.value,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { role.value = it })
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Эл.Почта") },
            value = email.value,
            shape = RoundedCornerShape(10.dp),
            onValueChange = { email.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Пароль") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(10.dp),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            if (loginState == AuthState.LOGIN) {
                Input("Войти")
            }else{
                Input("Зарегистрироваться")
            }
            //Input()
        }
    }

}*/