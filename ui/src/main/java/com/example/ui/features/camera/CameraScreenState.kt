package com.example.ui.features.camera

import androidx.annotation.StringRes
import androidx.camera.core.CameraSelector

data class CameraScreenState(
    val hasCameraPermission: Boolean? = null,
    val selectedPhotoPath: String? = null,
    @StringRes val takePhotoError: Int? = null,
    val isSendPhotoLoading: Boolean = false,
    @StringRes val sendPhotoError: Int? = null,
    val cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,
)
