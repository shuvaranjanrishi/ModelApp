package com.example.blooddonor.ui.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object SignUpScreenUser : Screen()
    object SignInScreen : Screen()
    object PasswordRecoveryScreen : Screen()
}

object BloodDonorAppRouter {
    val currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignInScreen)

    fun navigateTo(destination: Screen) {
        currentScreen.value = destination
    }
}