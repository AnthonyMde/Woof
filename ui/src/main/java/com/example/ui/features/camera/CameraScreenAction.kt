package com.example.ui.features.camera

sealed interface CameraScreenAction {
    data object OnCameraPermissionGranted : CameraScreenAction
}
