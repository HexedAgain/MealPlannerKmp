package com.example.mealplannerkmp.domain.model

import com.example.mealplannerkmp.domain.model.recipeUnit.RecipeUnit
import com.example.mealplannerkmp.domain.model.recipeUnit.SimpleRecipeUnit
import kotlinx.serialization.Serializable

@Serializable
data class RecipeQuantity(
    val qty: Float = 0.0f,
    val qtyMin: Float = 0.0f,
    val qtyMax: Float = 0.0f,
    val unit: RecipeUnit = SimpleRecipeUnit.Default
)