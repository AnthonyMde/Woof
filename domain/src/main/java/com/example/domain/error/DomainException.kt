package com.example.domain.error

sealed class DomainException : Throwable() {
    data object NoProfileFoundError : DomainException()
}
