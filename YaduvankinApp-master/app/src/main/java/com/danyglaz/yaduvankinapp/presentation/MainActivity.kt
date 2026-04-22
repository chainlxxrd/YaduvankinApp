package com.danyglaz.yaduvankinapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.danyglaz.yaduvankinapp.data.repository.LocalAuthManager
import com.danyglaz.yaduvankinapp.presentation.navigation.MainNavigation

import com.danyglaz.yaduvankinapp.presentation.ui.theme.YaduvankinAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var localAuthManager: LocalAuthManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YaduvankinAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    MainContent(
                        modifier = Modifier.padding(innerPadding),
                        isLoggedIn = localAuthManager.isLoggedIn()
                    )

                }
            }
        }
    }
}
@Composable
fun MainContent(
    modifier: Modifier= Modifier,
    isLoggedIn: Boolean
){
    MainNavigation(
        navHostController = rememberNavController(),
        modifier = modifier,
        isLoggedIn = isLoggedIn
        )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    YaduvankinAppTheme {
        MainContent(isLoggedIn = false)
    }
}