package com.example.mealplannerkmp.database.model.pojo

import kotlinx.serialization.Serializable

@Serializable
enum class DbRecipeDifficulty {
    Beginner,
    Easy,
    Advanced,
    Hard,
    Expert
}
