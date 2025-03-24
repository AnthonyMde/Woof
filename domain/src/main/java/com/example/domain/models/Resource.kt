package com.example.domain.models

sealed interface Resource<T> {
    class Loading<T> : Resource<T>
    class Success<T>(data: T? = null) : Resource<T>
    class Error<T>(val throwable: Throwable?) : Resource<T>
}