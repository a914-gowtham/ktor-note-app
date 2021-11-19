package com.gowtham.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.gowtham.components.AnnotatedClickableText
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarStyle


@Composable
fun LoginScreen(onLoginListener: () -> Unit) {

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
        OutlinedTextField(
            value = email, onValueChange = {
                email=it
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            placeholder = { Text("email") },
        )
        Spacer(modifier = Modifier.heightIn(20.dp))
        OutlinedTextField(
            value = password, onValueChange = {
                password=it
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            placeholder = { Text("password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.weight(2f))
        AnnotatedClickableText(onLoginListener)
        Button(
            modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults
                .buttonColors(backgroundColor = MaterialTheme.colors.onSurface),
            onClick = {

            }, shape = RoundedCornerShape(18.dp)
        ) {
            Text(
                text = "ui-login",
                modifier =
                Modifier.padding(vertical = 8.dp),
                style = TextStyle(fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,color = MaterialTheme.colors.background)
            )
        }
    }
}
