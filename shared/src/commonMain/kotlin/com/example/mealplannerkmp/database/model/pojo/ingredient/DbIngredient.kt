package com.example.mealplannerkmp.database.model.pojo.ingredient

import com.example.mealplannerkmp.database.model.pojo.DbRecipeQuantity
import kotlinx.serialization.Serializable

@Serializable
data class DbIngredient(
    val name: String,
    val quantity: DbRecipeQuantity,
    val isOptional: Boolean,
    val extraDetails: List<String>
) {
}