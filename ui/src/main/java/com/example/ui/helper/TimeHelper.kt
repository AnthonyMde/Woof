package com.example.ui.helper

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object TimeHelper {
    fun timestampToFormattedDate(timestamp: Long): String {
        val locale = Locale.getDefault()
        val pattern = if (locale.language == "fr") "dd/MM/yyyy" else "MM/dd/yyyy"
        val formatter = SimpleDateFormat(pattern, locale)

        return formatter.format(Date(timestamp))
    }
}
