package com.example.mealplannerkmp.database.model.pojo.nutrition

import kotlinx.serialization.Serializable

@Serializable
data class DbRecipeNutrition(
    val items: List<DbNutritionItem>
) {
}