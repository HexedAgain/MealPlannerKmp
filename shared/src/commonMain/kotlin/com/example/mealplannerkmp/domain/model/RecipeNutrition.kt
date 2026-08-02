package com.example.mealplannerkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeNutrition(
    val items: List<NutritionItem>
)

@Serializable
data class NutritionItem(
    val type: NutritionType,
    val qty: RecipeQuantity
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