package com.danyglaz.yaduvankinapp.presentation.ui.component
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp



@Composable
fun StyledButton(
    modifier: Modifier = Modifier.fillMaxWidth()
        .height(50.dp),
    onClick: () -> Unit,
    shape: Shape = RoundedCornerShape(10.dp),
    content: @Composable () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(size = 15.dp)
    ){
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)){
            content()
        }

    }
}