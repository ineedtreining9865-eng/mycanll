package com.example.mycanll.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Purple80,
    secondary = PurpleGrey40,
    background = LightBackground,
    surface = LightSurface,
    onPrimary = White,
    onSecondary = Black,
    onBackground = Black,
    onSurface = Black,
)

private val DarkColors = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey40,
    background = DarkBackground,
    surface = DarkSurface,
    onPrimary = Black,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
)

@Composable
fun MycanllTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
