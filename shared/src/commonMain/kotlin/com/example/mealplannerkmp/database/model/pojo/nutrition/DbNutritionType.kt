package com.example.mealplannerkmp.database.model.pojo.nutrition

import kotlinx.serialization.Serializable

@Serializable
enum class DbNutritionType {
    Calories,
    Fat,
    Saturates,
    Carbs,
    Fibre,
    Protein,
    Salt,
    Unknown
}