package com.example.mealplannerkmp.database.model.pojo.recipeUnit

import kotlinx.serialization.Serializable

@Serializable
sealed interface DbRecipeUnit {
    val shortName: String
}