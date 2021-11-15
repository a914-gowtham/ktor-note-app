package com.gowtham.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnnotatedClickableText(onLoginListener: () -> Unit) {

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 16.sp)) {
            append("already have an account? ")
        }
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
            append("login")
        }
    }
    ClickableText(
        annotatedString, modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
            .wrapContentWidth(align = Alignment.CenterHorizontally),
        style = TextStyle(color = MaterialTheme.colors.onSurface),
        onClick = {
            onLoginListener()
        })
}
