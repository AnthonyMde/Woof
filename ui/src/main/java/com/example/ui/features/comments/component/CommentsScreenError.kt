package com.example.ui.features.comments.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ui.component.ErrorText

@Composable
fun BoxScope.CommentsScreenError(
    @StringRes error: Int
) {
    ErrorText(
        message = stringResource(error),
        modifier = Modifier.align(Alignment.Center)
    )
}
