package com.example.ui.features.camera.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.ui.R
import com.example.ui.component.ErrorText
import com.example.ui.component.PetTalkDisplayView
import com.example.ui.features.camera.CameraScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun GeneratePetTalkView(
    petTalk: String?,
    isLoading: Boolean,
    @StringRes error: Int?,
    onAction: (CameraScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier,
        contentAlignment = Alignment.Center
    ) {
        when {
            error != null -> {
                ErrorText(
                    stringResource(error),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            petTalk == null -> {
                PetTalkButton(isLoading, onAction)
            }

            else -> PetTalkDisplayView(
                petTalk = petTalk,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = LocalDimensions.current.l)
            )
        }
    }
}

@Composable
fun PetTalkButton(isLoading: Boolean, onAction: (CameraScreenAction) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(LocalDimensions.current.corners))
            .background(MaterialTheme.colorScheme.secondary)
            .clickable {
                onAction(CameraScreenAction.OnGeneratePetTalkClicked)
            }
            .padding(horizontal = LocalDimensions.current.m, vertical = LocalDimensions.current.s)
    ) {
        if (!isLoading) {
            Icon(
                painter = painterResource(R.drawable.ic_magicpen_outlined),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
            Icon(
                painter = painterResource(R.drawable.ic_paw_outlined),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier.size(LocalDimensions.current.iconSmall),
                strokeWidth = LocalDimensions.current.stroke,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }

        Spacer(Modifier.width(LocalDimensions.current.s))

        Text(
            stringResource(R.string.camera_generate_pet_talk_button),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

