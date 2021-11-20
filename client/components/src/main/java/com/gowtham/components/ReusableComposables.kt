package com.gowtham.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnnotatedClickableText(
    title: String, desc: String,
    onBtnClicked: () -> Unit
) {

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 16.sp)) {
            append("$desc ")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
            append(title)
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(22.dp)
    ) {
        ClickableText(
            annotatedString, modifier = Modifier
                .padding(8.dp),
            style = TextStyle(color = MaterialTheme.colorScheme.onSurface),
            onClick = {
                onBtnClicked()
            })
    }

}

@Composable
fun DefaultTextField(
    value: String, hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false,
    valueListener: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = valueListener,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        placeholder = { Text(hint) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation =
        if (isPassword)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
    )
}

@Composable
fun DefaultButton(title: String,listener: ()-> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults
            .buttonColors(containerColor = MaterialTheme.colorScheme.onSurface),
        onClick = listener, shape = RoundedCornerShape(22.dp)
    ) {
        Text(
            text = title,
            modifier =
            Modifier.padding(vertical = 8.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp, color = MaterialTheme.colorScheme.background
            )
        )
    }
}
