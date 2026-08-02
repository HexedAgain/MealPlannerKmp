package com.example.mealplannerkmp.database.model.pojo

import com.example.mealplannerkmp.database.model.pojo.recipeUnit.DbRecipeUnit
import com.example.mealplannerkmp.database.model.pojo.recipeUnit.DbSimpleRecipeUnit
import kotlinx.serialization.Serializable

@Serializable
data class DbRecipeQuantity(
    val qty: Float = 0.0f,
    val qtyMin: Float = 0.0f,
    val qtyMax: Float = 0.0f,
    val unit: DbRecipeUnit = DbSimpleRecipeUnit.Default
)
