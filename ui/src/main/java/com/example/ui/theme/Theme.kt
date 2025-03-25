package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD7D0FE),
    onPrimary = Color(0xFF242529),
    secondary = Color(0xFFFFECBA),
    onSecondary = Color(0xFF242529),
    tertiary = Color(0xFFFF7473),
    onTertiary = Color(0xFFFEFEFE),
    surface = Color(0xFF1F2022),
    onSurface = Color(0xFFF9F8FD),
    background = Color(0xFF242529)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFD7D0FE),
    onPrimary = Color(0xFF242529),
    secondary = Color(0xFFFFECBA),
    onSecondary = Color(0xFF242529),
    tertiary = Color(0xFFFF7473),
    onTertiary = Color(0xFFFEFEFE),
    surface = Color(0xFFF3F1FB),
    onSurface = Color(0xFF242529),
    background = Color(0xFFF9F8FD)
)

@Composable
fun WoofTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}