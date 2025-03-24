package com.example.ui.helper

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.net.toUri
import java.io.File

class FileHelper(private val context: Context) {
    fun saveBitmapToTempFile(
        bitmap: Bitmap,
        fileName: String
    ): Uri {
        val file = File(context.cacheDir, fileName)
        file.outputStream().use {
            it.write(bitmap.toByteArray())
        }

        return file.toUri()
    }
}
