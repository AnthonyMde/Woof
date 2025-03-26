package com.example.ui.features.camera

import androidx.annotation.StringRes
import androidx.camera.core.CameraSelector

data class CameraScreenState(
    val isTakePhotoLoading: Boolean = false,
    val hasCameraPermission: Boolean? = null,
    val selectedPhotoPath: String? = null,
    @StringRes val takePhotoError: Int? = null,
    val isSendPhotoLoading: Boolean = false,
    @StringRes val sendPhotoError: Int? = null,
    val cameraSelector: CameraSelector = CameraSelector.DEFAULT_BACK_CAMERA,

    val petTalk: String? = null,
    val isPetTalkLoading: Boolean = false,
    @StringRes val petTalkError: Int? = null
)
