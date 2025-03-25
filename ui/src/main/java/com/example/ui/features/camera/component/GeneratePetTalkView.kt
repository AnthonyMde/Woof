package com.example.ui.features.camera.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.theme.LocalDimensions

@Composable
fun GeneratePetTalkView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .clip(RoundedCornerShape(LocalDimensions.current.corners))
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .clickable {
                // TODO
            }
            .padding(
                horizontal = LocalDimensions.current.m,
                vertical = LocalDimensions.current.s
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_magicpen_outlined),
                contentDescription = null
            )
            Icon(
                painter = painterResource(R.drawable.ic_paw_outlined),
                contentDescription = null
            )

            Spacer(Modifier.width(LocalDimensions.current.xs))

            Text(
                stringResource(R.string.camera_generate_pet_talk_button),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
