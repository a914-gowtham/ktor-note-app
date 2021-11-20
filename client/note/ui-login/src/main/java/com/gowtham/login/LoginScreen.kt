package com.gowtham.login

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.gowtham.components.AnnotatedClickableText
import com.gowtham.components.DefaultButton
import com.gowtham.components.DefaultTextField
import com.gowtham.core.Logger


@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onGotoRegClicked: () -> Unit,
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 28.dp, horizontal = 20.dp)
    ) {

        Text(
            text = "welcome back.",
            fontWeight = FontWeight.Bold, fontSize = 26.sp
        )
        Text(text = "login with your credentials!", fontSize = 24.sp)

        Spacer(modifier = Modifier.weight(1f))
        DefaultTextField(
            value = email,
            hint = "email",
            keyboardType = KeyboardType.Email
        ) {
            email = it
        }
        Spacer(modifier = Modifier.heightIn(20.dp))
        DefaultTextField(
            value = password,
            hint = "password",
            keyboardType = KeyboardType.Password,
            isPassword = true
        ) {
            password = it
        }
        Spacer(modifier = Modifier.weight(2f))
        AnnotatedClickableText(
            title = "register",
            desc = "don't have an account?", onBtnClicked = onGotoRegClicked
        )
        DefaultButton(title = "login"){

        }
    }
}

@Preview(name = "LoginScreen", showBackground = true)
@Composable
fun Preview() {
    val viewModel = LoginViewModel(Logger(""), "")
    LoginScreen(viewModel) {

    }
}
