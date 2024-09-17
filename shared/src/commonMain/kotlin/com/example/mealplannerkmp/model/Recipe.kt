package com.example.mealplannerkmp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO next step try to parse the recipeStep.json
//      Can then start coding up a simple view to render it

@Serializable
data class Recipe(
    val title: String,
    val description: String,
    val image: String? = null,
    val video: String? = null,
    val nutrition: RecipeNutrition? = null,
    @SerialName("preparation_time")
    val preparationTime: RecipeTime? = null,
    @SerialName("cook_time")
    val cookTime: RecipeTime,
    val difficulty: RecipeDifficulty = RecipeDifficulty.Easy,
    val serves: Int = 1,
    val ratings: Float? = null,
    val ingredients: List<IngredientSet>,
    @SerialName("timeline_steps")
    val timelineSteps: List<RecipeTimeLine>
) {
    fun validateCookTime(): Recipe? {
        with (cookTime) {
            val absTime = mins + 60 * hours
            val variableTime = (minsUpper - minsLower) + (hoursUpper - hoursLower)
            return when {
                validateTime() == null -> null
                absTime == 0f && variableTime == 0f -> null
                else -> this@Recipe
            }
        }
    }
}