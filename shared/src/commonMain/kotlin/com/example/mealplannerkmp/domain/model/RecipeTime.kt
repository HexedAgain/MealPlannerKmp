package com.example.mealplannerkmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeTime (
    val secs: Float = 0.0f,
    val secsLower: Float = 0.0f,
    val secsUpper: Float = 0.0f,
    val mins: Float = 0.0f,
    val minsLower: Float = 0.0f,
    val minsUpper: Float = 0.0f,
    val hours: Float = 0.0f,
    val hoursLower: Float = 0.0f,
    val hoursUpper: Float = 0.0f
) {
    companion object {
        val Zero = RecipeTime()
    }
    fun validateTime(): RecipeTime? {
        return when {
            secs < 0f || secsLower < 0f || secsUpper < 0f -> null
            mins < 0f || minsLower < 0f || minsUpper < 0f -> null
            hours < 0f || hoursLower < 0f || hoursUpper < 0f -> null
            secsUpper < secsLower -> null
            minsUpper < minsLower -> null
            hoursUpper < hoursLower -> null
            else -> this
        }
    }
}