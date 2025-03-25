package com.example.ui.features.shop.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.models.shop.ShopProduct
import com.example.ui.features.shop.ShopScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun ShopProductItemView(
    product: ShopProduct,
    onAction: (ShopScreenAction) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.xs),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(160.dp)
                .clip(RoundedCornerShape(LocalDimensions.current.corners))
                .clickable {
                    onAction(ShopScreenAction.OnProductClicked(product.affiliatedLink))
                }
                .background(MaterialTheme.colorScheme.surface)

        ) {
            AsyncImage(
                model = product.imageUriString,
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(LocalDimensions.current.corners))
            )
        }

        Spacer(Modifier.height(LocalDimensions.current.xs))

        Text(
            product.priceToEuros(),
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            product.name,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            product.brand,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }
}
