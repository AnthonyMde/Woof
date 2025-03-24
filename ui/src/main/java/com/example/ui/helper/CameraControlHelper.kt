package com.example.ui.helper

import android.content.Context
import androidx.camera.core.ImageCapture.OnImageCapturedCallback
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.view.LifecycleCameraController
import androidx.core.content.ContextCompat

object CameraControlHelper {
    fun takePhoto(
        context: Context,
        controller: LifecycleCameraController,
        onPhotoTaken: (ImageProxy) -> Unit,
        onError: (ImageCaptureException) -> Unit
    ) {
        controller.takePicture(
            ContextCompat.getMainExecutor(context),
            object : OnImageCapturedCallback() {
                override fun onCaptureSuccess(image: ImageProxy) {
                    super.onCaptureSuccess(image)
                    onPhotoTaken(image)
                }

                override fun onError(exception: ImageCaptureException) {
                    super.onError(exception)
                    onError(exception)
                }
            }
        )
    }
}
