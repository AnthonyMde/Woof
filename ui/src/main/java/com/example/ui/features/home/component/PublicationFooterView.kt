package com.example.ui.features.home.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.features.home.HomeScreenAction
import com.example.ui.features.home.model.PublicationUIModel
import com.example.ui.theme.LocalDimensions

@Composable
fun PublicationFooterView(
    publication: PublicationUIModel,
    onAction: (HomeScreenAction) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                onAction(HomeScreenAction.OnPublicationLikeClicked(publication.id))
            }
        ) {
            val icon = getIcon(publication.isLiked)
            val description = getDescription(publication.isLiked)
            val tint = getTint(publication.isLiked)

            Icon(
                painter = painterResource(icon),
                contentDescription = stringResource(description),
                tint = tint
            )
        }
        Text(
            publication.likes.size.toString(),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.offset(x = -LocalDimensions.current.s)
        )

        IconButton(
            onClick = {
                onAction(HomeScreenAction.OnPublicationCommentClicked(publication.id))
            }) {
            Icon(
                painter = painterResource(R.drawable.ic_comment_outlined),
                contentDescription = stringResource(R.string.publication_footer_view_comment_icon_description)
            )
        }
        Text(
            publication.comments.size.toString(),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.offset(x = -LocalDimensions.current.s)
        )
    }
}

@Composable
private fun getTint(isLiked: Boolean): Color = if (isLiked) {
    Color.Red
} else {
    MaterialTheme.colorScheme.onSurface
}

private fun getIcon(isLiked: Boolean) = if (isLiked) {
    R.drawable.ic_heart_filled
} else R.drawable.ic_heart_outlined

private fun getDescription(isLiked: Boolean) = if (isLiked) {
    R.string.publication_footer_view_remove_like_icon_description
} else {
    R.string.publication_footer_view_like_icon_description
}