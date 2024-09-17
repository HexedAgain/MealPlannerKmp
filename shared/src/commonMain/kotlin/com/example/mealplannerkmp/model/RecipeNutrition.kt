package com.example.mealplannerkmp.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeNutrition(
    val items: List<NutritionType>
)

@Serializable
data class NutritionItem(
    val type: NutritionType,
    val qty: Float,
    val unit: RecipeUnit
)

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