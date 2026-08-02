package com.example.mealplannerkmp.domain.model.nutrition

import com.example.mealplannerkmp.domain.model.RecipeQuantity
import kotlinx.serialization.Serializable

@Serializable
data class NutritionItem(
    val type: NutritionType,
    val qty: RecipeQuantity
)