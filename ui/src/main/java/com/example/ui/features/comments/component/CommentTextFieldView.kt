package com.example.ui.features.comments.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.component.PlaceholderText
import com.example.ui.features.comments.CommentsScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun CommentTextFieldView(
    value: String,
    error: String? = null,
    onAction: (CommentsScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(bottom = LocalDimensions.current.l)
    ) {
        OutlinedTextField(value = value,
            onValueChange = { text ->
                onAction(CommentsScreenAction.OnCommentInputValueChanged(text))
            },
            placeholder = { PlaceholderText(stringResource(R.string.comments_screen_comment_input_placeholder)) },
            textStyle = MaterialTheme.typography.bodyLarge,
            isError = error != null,
            maxLines = 3,
            shape = RoundedCornerShape(LocalDimensions.current.corners),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = LocalDimensions.current.s)
                .background(MaterialTheme.colorScheme.surface)
        )

        IconButton(onClick = {
            CommentsScreenAction.OnSendCommentClicked(value)
        }) {
            Icon(
                painter = painterResource(R.drawable.ic_send_outlined),
                contentDescription = stringResource(R.string.comments_screen_send_comment_icon_description),
                Modifier.size(LocalDimensions.current.iconMedium)
            )
        }
    }
}
