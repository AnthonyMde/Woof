package com.example.domain.helper

class SystemClock : Clock {
    override fun nowMillis(): Long = System.currentTimeMillis()
}
