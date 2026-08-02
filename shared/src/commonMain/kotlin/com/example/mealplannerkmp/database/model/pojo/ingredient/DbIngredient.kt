package com.example.mealplannerkmp.database.model.pojo.ingredient

import kotlinx.serialization.Serializable

@Serializable
data class DbIngredient(
    val name: String,
    val foodCategories: List<String>,
    val isOptional: Boolean,
    val extraDetails: List<String>
) {
}