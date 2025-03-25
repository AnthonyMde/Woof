package com.example.ui.features.comments.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import com.example.ui.R
import com.example.ui.component.ErrorText
import com.example.ui.component.PlaceholderText
import com.example.ui.features.comments.CommentsScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun CommentTextFieldView(
    value: String,
    isLoading: Boolean,
    @StringRes error: Int?,
    onAction: (CommentsScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboard = LocalSoftwareKeyboardController.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(bottom = LocalDimensions.current.l)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.xs),
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = { text ->
                    onAction(CommentsScreenAction.OnCommentInputValueChanged(text))
                },
                placeholder = { PlaceholderText(stringResource(R.string.comments_screen_comment_input_placeholder)) },
                textStyle = MaterialTheme.typography.bodyLarge,
                isError = error != null,
                maxLines = 3,
                keyboardOptions = KeyboardOptions.Default.copy(
                    capitalization = KeyboardCapitalization.Sentences
                ),
                shape = RoundedCornerShape(LocalDimensions.current.corners),
                modifier = Modifier
                    .padding(horizontal = LocalDimensions.current.s)
                    .background(MaterialTheme.colorScheme.surface)
            )
            error?.let {
                ErrorText(
                    stringResource(it),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        IconButton(
            onClick = {
                onAction(CommentsScreenAction.OnSendCommentClicked(value))
                keyboard?.hide()
            },
            enabled = !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    strokeWidth = LocalDimensions.current.stroke,
                    modifier = Modifier.size(LocalDimensions.current.icon)
                )
            } else {
                Icon(
                    painter = painterResource(R.drawable.ic_send_outlined),
                    contentDescription = stringResource(R.string.comments_screen_send_comment_icon_description),
                    Modifier.size(LocalDimensions.current.iconMedium)
                )
            }
        }
    }
}
