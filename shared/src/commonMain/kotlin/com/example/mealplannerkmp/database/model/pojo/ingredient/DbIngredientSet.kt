package com.example.mealplannerkmp.database.model.pojo.ingredient

import kotlinx.serialization.Serializable

@Serializable
data class DbIngredientSet (
    val ingredientClass: DbIngredientClass,
    val ingredients: List<DbIngredient>
)