package com.example.mealplannerkmp.domain.model.ingredient

import kotlinx.serialization.Serializable

@Serializable
data class IngredientSet(
    val ingredientClass: IngredientClass,
    val ingredients: List<Ingredient>
)

