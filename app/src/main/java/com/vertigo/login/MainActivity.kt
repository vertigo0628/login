package com.vertigo.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.vertigo.login.ui.homeScreen
import com.vertigo.login.ui.loginScreen
import com.vertigo.login.ui.signupScreen
import com.vertigo.login.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                AuthApp()

                }
            }
        }
    }
@Composable
fun AuthApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable ("login") { loginScreen(navController)}
        composable ("signup") { signupScreen(navController)}
        composable ("home") { homeScreen(navController)}
    }

}