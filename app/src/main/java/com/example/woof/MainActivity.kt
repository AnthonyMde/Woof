package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import com.example.woof.app.MainScreen
import com.example.ui.theme.Dimensions
import com.example.ui.theme.LocalDimensions
import com.example.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(
                LocalDimensions provides Dimensions()
            ) {
                WoofTheme {
                    MainScreen()
                }
            }
        }
    }
}