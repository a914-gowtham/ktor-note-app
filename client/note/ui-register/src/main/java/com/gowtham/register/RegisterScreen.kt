package com.gowtham.register


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.gowtham.components.AnnotatedClickableText
import com.gowtham.components.DefaultButton
import com.gowtham.components.DefaultTextField


@Composable
fun RegisterScreen(onGotoLoginPage: () -> Unit) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 28.dp, horizontal = 20.dp)
    ) {

        Text(
            text = "create your account.",
            fontWeight = FontWeight.Bold, fontSize = 26.sp
        )
        Text(text = "won't take more than a minute!", fontSize = 24.sp)

        Spacer(modifier = Modifier.weight(1f))
        DefaultTextField(
            value = email,
            hint = "email",
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
            title = "login",
            desc = "already have an account?", onBtnClicked = onGotoLoginPage
        )
        DefaultButton(title = "register") {

        }
    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun Preview() {
    RegisterScreen {

    }
}