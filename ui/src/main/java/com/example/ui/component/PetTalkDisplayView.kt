package com.example.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import com.example.ui.R
import com.example.ui.theme.LocalDimensions

@Composable
fun PetTalkDisplayView(
    petTalk: String,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        PetTalkIcons(textColor)
        Spacer(Modifier.width(LocalDimensions.current.xs))
        Text(
            "\"${petTalk}\"",
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic,
            color = textColor
        )
    }
}

@Composable
private fun PetTalkIcons(tint: Color) {
    Icon(
        painter = painterResource(R.drawable.ic_magicpen_outlined),
        contentDescription = null,
        tint = tint
    )
    Icon(
        painter = painterResource(R.drawable.ic_paw_outlined),
        contentDescription = null,
        tint = tint
    )
}
