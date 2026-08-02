package com.example.mealplannerkmp.domain.model.nutrition

import kotlinx.serialization.Serializable

@Serializable
enum class NutritionType {
    Calories,
    Fat,
    Saturates,
    Carbs,
    Fibre,
    Protein,
    Salt
}