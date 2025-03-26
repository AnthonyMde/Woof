package com.example.ui.helper

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.domain.models.publication.Publication

@Composable
fun getRandomColor(tint: Color): Color {
    val colors = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary
    )
    return colors.filter { it != tint }.random()
}

@Composable
fun getPublicationColorFrom(color: Color): Publication.Color {
    return when (color) {
        MaterialTheme.colorScheme.primary -> Publication.Color.PRIMARY
        MaterialTheme.colorScheme.secondary -> Publication.Color.SECONDARY
        else -> Publication.Color.TERTIARY
    }
}
