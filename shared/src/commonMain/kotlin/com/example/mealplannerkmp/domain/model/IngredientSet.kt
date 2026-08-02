package com.example.mealplannerkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class IngredientSet(
    val ingredientClass: IngredientClass,
    val ingredients: List<Ingredient>
)

@Serializable
sealed interface IngredientClass {
    data object Global: IngredientClass
    class Custom(val title: String): IngredientClass
}

@Serializable
data class Ingredient(
    val name: String,
    val quantity: RecipeQuantity,
    val extraDetails: List<String> = listOf(),
    val isOptional: Boolean = false
)