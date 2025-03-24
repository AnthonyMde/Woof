package com.example.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.ui.theme.LocalDimensions

@Composable
fun LoadingButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isLoading: Boolean = true,
    label: String,
    buttonColors: ButtonColors? = null,
    shrinkToText: Boolean = false
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(LocalDimensions.current.m),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    label,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    modifier = getTextModifier(modifier, shrinkToText)
                )
                if (isLoading) CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = LocalDimensions.current.stoke,
                    modifier = Modifier
                        .size(LocalDimensions.current.loading)
                )
            }
        },
        colors = buttonColors ?: ButtonDefaults.buttonColors(),
        modifier = modifier
    )
}

@Composable
private fun RowScope.getTextModifier(
    modifier: Modifier,
    shrinkToText: Boolean
): Modifier {
    return if (shrinkToText) {
        modifier
    } else {
        modifier.weight(1f)
    }
}
