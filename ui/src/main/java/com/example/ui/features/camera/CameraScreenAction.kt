package com.example.ui.features.camera

import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy

sealed interface CameraScreenAction {
    data object OnCameraPermissionGranted : CameraScreenAction
    data class OnTakePhoto(val image: ImageProxy) : CameraScreenAction
    data class OnTakePhotoError(val error: ImageCaptureException) : CameraScreenAction
}
