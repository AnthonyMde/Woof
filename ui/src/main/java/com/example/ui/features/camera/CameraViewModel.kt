package com.example.ui.features.camera

import androidx.lifecycle.ViewModel
import com.example.ui.helper.PermissionsHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class CameraViewModel(
    private val permissionsHelper: PermissionsHelper
) : ViewModel() {
    private val _state = MutableStateFlow(CameraScreenState())
    val state = _state.asStateFlow().onStart {
        _state.update {
            it.copy(hasCameraPermission = permissionsHelper.hasCameraPermission())
        }
    }

    fun onAction(action: CameraScreenAction) {
        when (action) {
            CameraScreenAction.OnCameraPermissionGranted -> {
                _state.update {
                    it.copy(hasCameraPermission = true)
                }
            }
        }
    }
}
