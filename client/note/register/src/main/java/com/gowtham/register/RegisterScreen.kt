package com.gowtham.register


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.gowtham.components.AnnotatedClickableText


@Composable
fun RegisterScreen(onLoginListener: () -> Unit) {

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
                text = "register",
                modifier =
                Modifier.padding(vertical = 8.dp),
                style = TextStyle(fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,color = MaterialTheme.colors.background)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    RegisterScreen {

    }
}