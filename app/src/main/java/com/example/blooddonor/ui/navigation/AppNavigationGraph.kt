package com.example.blooddonor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blooddonor.ui.screens.HomeScreen
import com.example.blooddonor.ui.screens.PasswordRecoveryScreen
import com.example.blooddonor.ui.screens.SignInScreen
import com.example.blooddonor.ui.screens.SignUpScreenUser

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {

        composable(Routes.HOME_SCREEN) {
            HomeScreen()
        }
        composable(Routes.SIGN_IN_SCREEN) {
            SignInScreen()
        }
        composable(Routes.SIGN_UP_SCREEN) {
            SignUpScreenUser()
        }
        composable(Routes.PASSWORD_RECOVERY_SCREEN) {
            PasswordRecoveryScreen()
        }
    }
}