package com.example.mealplannerkmp.database.model.pojo.nutrition

import com.example.mealplannerkmp.database.model.pojo.DbRecipeQuantity
import kotlinx.serialization.Serializable

@Serializable
data class DbNutritionItem(
    val type: DbNutritionType = DbNutritionType.Unknown,
    val qty: DbRecipeQuantity
)