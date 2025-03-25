package com.example.ui.features.shop.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ui.R
import com.example.ui.component.PlaceholderText
import com.example.ui.features.shop.ShopScreenAction
import com.example.ui.theme.LocalDimensions

@Composable
fun ShopSearchView(
    value: String,
    onAction: (ShopScreenAction) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = { search ->
            onAction(ShopScreenAction.OnSearchInputChanged(search))
        },
        placeholder = { PlaceholderText(stringResource(R.string.shop_search_placeholder)) },
        singleLine = true,
        shape = RoundedCornerShape(LocalDimensions.current.corners),
        modifier = modifier
    )
}
