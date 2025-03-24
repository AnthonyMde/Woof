package com.example.ui.features.camera

import android.net.Uri
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy

sealed interface CameraScreenAction {
    data object OnCameraPermissionGranted : CameraScreenAction
    data class OnTakePhoto(val image: ImageProxy) : CameraScreenAction
    data class OnTakePhotoError(val error: ImageCaptureException) : CameraScreenAction
    data object OnPhotoValidated : CameraScreenAction
    data object OnClearPhoto : CameraScreenAction
    data class OnPickPhoto(val uri: Uri) : CameraScreenAction
    data object OnSwitchCamera : CameraScreenAction
}
