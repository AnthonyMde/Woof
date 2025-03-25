package com.example.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import com.example.ui.R
import com.example.ui.theme.LocalDimensions

@Composable
fun PetTalkDisplayView(
    petTalk: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        PetTalkIcons()
        Spacer(Modifier.width(LocalDimensions.current.xs))
        Text(
            "\"${petTalk}\"",
            style = MaterialTheme.typography.bodyMedium,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
private fun PetTalkIcons() {
    Icon(
        painter = painterResource(R.drawable.ic_magicpen_outlined),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onSurface
    )
    Icon(
        painter = painterResource(R.drawable.ic_paw_outlined),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.onSurface
    )
}
