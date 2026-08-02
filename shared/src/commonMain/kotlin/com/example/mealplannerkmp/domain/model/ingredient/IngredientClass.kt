package com.example.mealplannerkmp.domain.model.ingredient

import kotlinx.serialization.Serializable

@Serializable
sealed interface IngredientClass {
    data object Global: IngredientClass
    class Custom(val title: String): IngredientClass
}