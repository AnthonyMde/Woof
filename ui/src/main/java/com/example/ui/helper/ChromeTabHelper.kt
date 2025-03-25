package com.example.ui.helper

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

fun openChromeTab(context: Context, url: String) {
    val intent = CustomTabsIntent.Builder().build()
    intent.launchUrl(context, Uri.parse(url))
}
