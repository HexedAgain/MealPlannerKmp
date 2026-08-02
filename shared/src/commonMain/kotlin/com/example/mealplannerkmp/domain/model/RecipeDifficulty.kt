package com.example.mealplannerkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
enum class RecipeDifficulty {
    Beginner,
    Easy,
    Advanced,
    Hard,
    Expert
}