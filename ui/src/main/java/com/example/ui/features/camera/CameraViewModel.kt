package com.example.ui.features.camera

import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import com.example.ui.R
import com.example.ui.helper.CameraControlHelper
import com.example.ui.helper.FileHelper
import com.example.ui.helper.PermissionsHelper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class CameraViewModel(
    private val permissionsHelper: PermissionsHelper,
    private val fileHelper: FileHelper
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

            is CameraScreenAction.OnTakePhoto -> onPhotoTaken(action.image)
            is CameraScreenAction.OnTakePhotoError -> {
                _state.update {
                    it.copy(takePhotoError = R.string.camera_screen_take_photo_error)
                }
            }

            CameraScreenAction.OnClearPhoto -> {
                _state.update {
                    it.copy(selectedPhotoPath = null)
                }
            }

            CameraScreenAction.OnPhotoValidated -> {
                // TODO
            }
        }
    }

    private fun onPhotoTaken(image: ImageProxy) {
        _state.update { it.copy(takePhotoError = null) }

        val rotatedBitmap = CameraControlHelper.imageProxyToRotatedBitmap(image)
        val uriString = fileHelper.saveBitmapToTempFile(
            bitmap = rotatedBitmap,
            fileName = "${image.imageInfo.timestamp}.jpeg"
        ).toString()

        _state.update { it.copy(selectedPhotoPath = uriString) }
    }
}
