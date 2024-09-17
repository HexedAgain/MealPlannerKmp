package com.example.mealplannerkmp.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeStep (
    val title: String,
    val body: String,
    val time: RecipeTime
)