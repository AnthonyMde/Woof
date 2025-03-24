package com.example.ui.features.camera

import androidx.annotation.StringRes

data class CameraScreenState(
    val hasCameraPermission: Boolean? = null,
    val selectedPhotoPath: String? = null,
    @StringRes val takePhotoError: Int? = null,
    val isSendPhotoLoading: Boolean = false,
    @StringRes val sendPhotoError: Int? = null,
)
