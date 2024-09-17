package com.example.mealplannerkmp.model

import kotlinx.serialization.json.Json

object RecipeParser {
    fun fromJson(jsonString: String): Recipe {
        return Json.decodeFromString(Recipe.serializer(), jsonString)
    }
}