package com.example.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    val s: Dp = 8.dp,
    val sm: Dp = 12.dp,
    val m: Dp = 16.dp,
    val l: Dp = 24.dp,
    val xl: Dp = 32.dp,
    val xxl: Dp = 40.dp,

    val iconSmall: Dp = 18.dp,
    val icon: Dp = 24.dp,
    val iconMedium: Dp = 32.dp,
    val iconLarge: Dp = 48.dp,
    val iconExtraLarge: Dp = 56.dp,

    val stroke: Dp = 2.dp,
    val loading: Dp = 20.dp,

    val corners: Dp = 30.dp
)

val LocalDimensions = staticCompositionLocalOf { Dimensions() }