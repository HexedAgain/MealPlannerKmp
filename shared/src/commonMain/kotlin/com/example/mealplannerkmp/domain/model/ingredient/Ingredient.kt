package com.example.mealplannerkmp.domain.model.ingredient

import com.example.mealplannerkmp.domain.model.RecipeQuantity
import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val name: String,
    val quantity: RecipeQuantity,
    val extraDetails: List<String> = listOf(),
    val isOptional: Boolean = false
)