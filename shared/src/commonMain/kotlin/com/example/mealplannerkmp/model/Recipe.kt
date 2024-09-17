package com.example.mealplannerkmp.model

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
    val preparationTime: RecipeTime? = null,
    val cookTime: RecipeTime,
    val difficulty: RecipeDifficulty = RecipeDifficulty.Easy,
    val serves: Int = 1,
    val ratings: Float? = null,
    val ingredients: List<IngredientSet>,
    val timelineSteps: List<RecipeTimeLine>
)