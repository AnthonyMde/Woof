package com.example.ui.features.camera

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageProxy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.PostPublicationModel
import com.example.domain.models.Resource
import com.example.domain.usecase.GeneratePetTalkUseCase
import com.example.domain.usecase.user.GetUserSessionUseCase
import com.example.domain.usecase.publication.PostPublicationUseCase
import com.example.ui.R
import com.example.ui.helper.CameraControlHelper
import com.example.ui.helper.FileHelper
import com.example.ui.helper.PermissionsHelper
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CameraViewModel(
    private val getUserSessionUseCase: GetUserSessionUseCase,
    private val postPublicationUseCase: PostPublicationUseCase,
    private val generatePetTalkUseCase: GeneratePetTalkUseCase,
    private val permissionsHelper: PermissionsHelper,
    private val fileHelper: FileHelper
) : ViewModel() {
    private val _state = MutableStateFlow(CameraScreenState())
    val state = _state.asStateFlow().onStart {
        _state.update {
            it.copy(hasCameraPermission = permissionsHelper.hasCameraPermission())
        }
    }
    private val _navigationEvent = MutableSharedFlow<CameraScreenNavigationEvent>(
        extraBufferCapacity = 1,
        replay = 0,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )
    val navigationEvent = _navigationEvent.asSharedFlow()

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
                    it.copy(
                        selectedPhotoPath = null,
                        petTalk = null,
                        petTalkError = null,
                        sendPhotoError = null
                    )
                }
            }

            CameraScreenAction.OnPhotoValidated -> postPublication()
            is CameraScreenAction.OnPickPhoto -> {
                _state.update { it.copy(selectedPhotoPath = action.uri.toString()) }
            }

            CameraScreenAction.OnSwitchCamera -> onSwitchCamera()
            CameraScreenAction.OnGeneratePetTalkClicked -> generatePetTalk()
        }
    }

    private fun generatePetTalk() = viewModelScope.launch {
        val imageUriString = _state.value.selectedPhotoPath
        if (imageUriString == null) {
            _state.update {
                it.copy(
                    petTalkError = R.string.generate_pet_talk_error
                )
            }
            return@launch
        }

        generatePetTalkUseCase(imageUriString).collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _state.update { it.copy(
                        petTalkError = R.string.generate_pet_talk_error,
                        isPetTalkLoading = false
                    ) }
                }
                is Resource.Loading -> {
                    _state.update { it.copy(
                        petTalkError = null,
                        isPetTalkLoading = true
                    ) }
                }
                is Resource.Success -> {
                    _state.update { it.copy(
                        petTalkError = null,
                        isPetTalkLoading = false,
                        petTalk = result.data
                    ) }
                }
            }
        }
    }

    private fun onSwitchCamera() {
        val currentCameraSelector = _state.value.cameraSelector
        val newCameraSelector = if (currentCameraSelector == CameraSelector.DEFAULT_FRONT_CAMERA) {
            CameraSelector.DEFAULT_BACK_CAMERA
        } else {
            CameraSelector.DEFAULT_FRONT_CAMERA
        }
        _state.update { it.copy(cameraSelector = newCameraSelector) }
    }

    private fun postPublication() = viewModelScope.launch {
        val session = getUserSessionUseCase()
        val imageUriString = _state.value.selectedPhotoPath
        val petTalk = _state.value.petTalk

        if (imageUriString != null) {
            val postPublicationModel = PostPublicationModel(
                userId = session.id,
                imageUriString = imageUriString,
                petTalk = petTalk
            )
            postPublicationUseCase(postPublicationModel).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isSendPhotoLoading = false,
                                sendPhotoError = R.string.camera_screen_send_photo_error
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _state.update { it.copy(isSendPhotoLoading = true, sendPhotoError = null) }
                    }

                    is Resource.Success -> {
                        _state.update { it.copy(isSendPhotoLoading = false) }
                        _navigationEvent.tryEmit(CameraScreenNavigationEvent.GoBackHome)
                    }
                }
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
