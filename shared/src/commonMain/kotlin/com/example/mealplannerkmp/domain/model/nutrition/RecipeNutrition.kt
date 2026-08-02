package com.example.mealplannerkmp.domain.model.nutrition

import kotlinx.serialization.Serializable

@Serializable
data class RecipeNutrition(
    val items: List<NutritionItem>
)