@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.blooddonor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blooddonor.R
import com.example.blooddonor.ui.components.ButtonComponent
import com.example.blooddonor.ui.components.ClickableTextComponent
import com.example.blooddonor.ui.components.DividerTextComponent
import com.example.blooddonor.ui.components.HeadingTextComponent
import com.example.blooddonor.ui.components.MyTextFieldComponent
import com.example.blooddonor.ui.components.NormalTextComponent
import com.example.blooddonor.ui.components.PasswordTextFieldComponent
import com.example.blooddonor.ui.components.UnderlinedTextComponent
import com.example.blooddonor.ui.navigation.BloodDonorAppRouter
import com.example.blooddonor.ui.navigation.Screen
import com.example.blooddonor.ui.navigation.SystemBackButtonHandler
import com.example.blooddonor.ui.theme.Purple40
import com.example.blooddonor.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRecoveryScreen() {
    Surface(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(28.dp)

    ) {
        Column {
            NormalTextComponent(value = stringResource(id = R.string.welcome))
            HeadingTextComponent(value = stringResource(id = R.string.recover_password))
        }
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            MyTextFieldComponent(
                painterResource(id = R.drawable.outline_email_24),
                labelValue = stringResource(id = R.string.email),
                value = ""
            )
            PasswordTextFieldComponent(
                painterResource(id = R.drawable.outline_vpn_key_24),
                labelValue = stringResource(id = R.string.password),
                value = ""
            )
            PasswordTextFieldComponent(
                painterResource(id = R.drawable.outline_vpn_key_24),
                labelValue = stringResource(id = R.string.confirm_password),
                value = ""
            )
            Spacer(modifier = Modifier.height(40.dp))
            ButtonComponent(value = stringResource(id = R.string.change_password))

        }
    }

    SystemBackButtonHandler {
        BloodDonorAppRouter.navigateTo(Screen.SignInScreen)
    }
}

@Preview
@Composable
fun DefaultPreviewOfPasswordRecoveryScreen() {
    SignInScreen()
}