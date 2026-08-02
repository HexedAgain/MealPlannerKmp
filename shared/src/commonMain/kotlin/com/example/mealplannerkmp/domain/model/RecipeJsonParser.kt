package com.example.mealplannerkmp.domain.model

import kotlinx.serialization.json.Json

object RecipeParser {
    fun fromJson(jsonString: String): Recipe? {
        val recipe = Json.decodeFromString(Recipe.serializer(), jsonString)
        return recipe
            .validateCookTime()
    }

    fun toJson(recipe: Recipe): String {
        return Json.encodeToString(Recipe.serializer(), recipe)
    }
}