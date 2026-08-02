package com.example.mealplannerkmp.database.model.pojo

import kotlinx.serialization.Serializable

@Serializable
data class DbRecipeTime (
    val secs: Float = 0.0f,
    val secsLower: Float = 0.0f,
    val secsUpper: Float = 0.0f,
    val mins: Float = 0.0f,
    val minsLower: Float = 0.0f,
    val minsUpper: Float = 0.0f,
    val hours: Float = 0.0f,
    val hoursLower: Float = 0.0f,
    val hoursUpper: Float = 0.0f
)
