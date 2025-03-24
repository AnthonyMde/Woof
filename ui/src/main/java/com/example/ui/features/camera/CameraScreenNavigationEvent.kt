package com.example.ui.features.camera

sealed interface CameraScreenNavigationEvent {
    data object GoBackHome : CameraScreenNavigationEvent
}
