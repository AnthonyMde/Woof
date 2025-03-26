package com.example.ui.features.shop

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.features.shop.component.ShopProductItemView
import com.example.ui.features.shop.component.ShopSearchView
import com.example.ui.helper.openChromeTab
import com.example.ui.theme.LocalDimensions
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ShopScreenRoot(
    viewModel: ShopViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle(ShopScreenState())
    val context = LocalContext.current

    ShopScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is ShopScreenAction.OnProductClicked -> {
                    openChromeTab(context, action.productUri)
                }
                else -> viewModel.onAction(action)
            }
        }
    )
}

@Composable
fun ShopScreen(
    state: ShopScreenState,
    onAction: (ShopScreenAction) -> Unit
) {
    val focus = LocalFocusManager.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(null) {
                detectTapGestures(
                    onTap = { focus.clearFocus() }
                )
            }
            .padding(top = LocalDimensions.current.l)
    ) {
        ShopSearchView(
            value = state.searchInputValue,
            onAction = onAction,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = LocalDimensions.current.l)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(LocalDimensions.current.l),
            horizontalArrangement = Arrangement.spacedBy(LocalDimensions.current.l),
            contentPadding = PaddingValues(LocalDimensions.current.l)
        ) {
            items(state.products) { product ->
                ShopProductItemView(product, onAction)
            }
        }
    }
}