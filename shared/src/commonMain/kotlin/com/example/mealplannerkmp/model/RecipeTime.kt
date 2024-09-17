package com.example.mealplannerkmp.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeTime (
    val mins: Float = 0.0f,
    val minsLower: Float = 0.0f,
    val minsUpper: Float = 0.0f,
    val hours: Float = 0.0f,
    val hoursLower: Float = 0.0f,
    val hoursUpper: Float = 0.0f
)