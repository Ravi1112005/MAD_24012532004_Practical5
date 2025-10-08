package com.example.mad_24012532004_practical5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mad_24012532004_practical5.screen.LoginUI
import com.example.mad_24012532004_practical5.screen.RegisterUI
import com.example.mad_24012532004_practical5.ui.theme.MAD_24012532004_Practical5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MAD_24012532004_Practical5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var isLoginScreen by rememberSaveable { mutableStateOf(true) }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (isLoginScreen) {
                            // Pass a lambda to navigate to the Register screen
                            LoginUI(onSignUpClicked = { isLoginScreen = false })
                        } else {
                            // Pass a lambda to navigate back to the Login screen
                            RegisterUI(onLoginClicked = { isLoginScreen = true })
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAD_24012532004_Practical5Theme {
        var isLoginScreen by rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isLoginScreen) {
                LoginUI(onSignUpClicked = { isLoginScreen = false })
            } else {
                RegisterUI(onLoginClicked = { isLoginScreen = true })
            }
        }
    }
}