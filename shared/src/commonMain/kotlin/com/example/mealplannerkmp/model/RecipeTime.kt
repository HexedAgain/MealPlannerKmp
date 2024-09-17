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
) {
    fun validateTime(): RecipeTime? {
        return when {
            mins < 0f || hours < 0f || minsLower < 0f || minsUpper < 0f || hoursLower < 0f || hoursUpper < 0f -> null
            minsUpper < minsLower -> null
            hoursUpper < hoursLower -> null
            else -> this
        }
    }
}