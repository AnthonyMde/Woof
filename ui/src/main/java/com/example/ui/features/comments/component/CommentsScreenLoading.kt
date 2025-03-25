package com.example.ui.features.comments.component

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BoxScope.CommentsScreenLoading() {
    CircularProgressIndicator(
        modifier = Modifier.align(Alignment.Center)
    )
}
