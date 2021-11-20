package com.noteapp.client.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColorScheme(
    primary = Purple200,
    onPrimary = Color.Black,
    primaryContainer = Purple700,
    onPrimaryContainer = Teal200
)

private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    onPrimary = Color.White,
    primaryContainer = Purple700,
    onPrimaryContainer = Teal200
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TAppTheme(darkTheme: Boolean = isSystemInDarkTheme(),
              content: @Composable() () -> Unit) {
    val colorScheme = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        if (darkTheme)
            dynamicDarkColorScheme(context)
        else
            dynamicLightColorScheme(context)
    } else if (darkTheme) {
        DarkColorPalette
    } else
        LightColorPalette

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
