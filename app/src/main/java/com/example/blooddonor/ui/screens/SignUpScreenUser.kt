@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.blooddonor.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.example.blooddonor.ui.navigation.BloodDonorAppRouter
import com.example.blooddonor.ui.navigation.Screen
import com.example.blooddonor.ui.navigation.SystemBackButtonHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreenUser() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        LazyColumn {
            item {
                NormalTextComponent(value = stringResource(id = R.string.welcome))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(
                    painterResource(id = R.drawable.outline_person_24),
                    labelValue = stringResource(id = R.string.name),
                    value = ""
                )
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
                MyTextFieldComponent(
                    painterResource(id = R.drawable.outline_location_on_24),
                    labelValue = stringResource(id = R.string.zilla),
                    value = ""
                )
                MyTextFieldComponent(
                    painterResource(id = R.drawable.outline_location_on_24),
                    labelValue = stringResource(id = R.string.address),
                    value = ""
                )
                MyTextFieldComponent(
                    painterResource(id = R.drawable.outline_person_24),
                    labelValue = stringResource(id = R.string.gender),
                    value = ""
                )
                MyTextFieldComponent(
                    painterResource(id = R.drawable.outline_person_24),
                    labelValue = stringResource(id = R.string.age),
                    value = ""
                )
                MyTextFieldComponent(
                    painterResource(id = R.drawable.outline_smartphone_24),
                    labelValue = stringResource(id = R.string.phone),
                    value = ""
                )
                Spacer(modifier = Modifier.height(20.dp))
                ButtonComponent(value = stringResource(id = R.string.register))
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                Spacer(modifier = Modifier.height(20.dp))
                ClickableTextComponent(isSignInPage = false, onTextSelected = {
                    BloodDonorAppRouter.navigateTo(Screen.SignInScreen)
                })
            }
        }
    }

    SystemBackButtonHandler {
        BloodDonorAppRouter.navigateTo(Screen.SignInScreen)
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignupScreen() {
    SignUpScreenUser()
}