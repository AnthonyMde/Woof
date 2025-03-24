package com.example.ui.features.home

import com.example.domain.models.Publication

data class HomeScreenState(
    val publications: List<Publication> = emptyList()
)