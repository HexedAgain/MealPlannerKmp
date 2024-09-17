package com.example.mealplannerkmp.model

import kotlin.test.Test
import kotlin.test.assertEquals

class RecipeParserTest {
    @Test
    fun `given a recipe string with minimal necessary details if the cookTime has no positive temporal component it returns null`() {
        val recipe = RecipeParser.fromJson(RecipeParser.toJson(recipeBasic))?.copy()

        assertEquals(null, recipe)
    }
    @Test
    fun `given a recipe string with minimal necessary details if the cookTime has malformed temporal components it returns null`() {
        val recipe = RecipeParser.fromJson(RecipeParser.toJson(recipeBasic.copy(cookTime = RecipeTime(minsLower = 123f))))?.copy()

        assertEquals(null, recipe)
    }
    @Test
    fun `given a recipe string with minimal necessary details and well defined temporal components it returns a recipe`() {
        val wellDefinedRecipe = recipeBasic.copy(cookTime = RecipeTime(mins = 123f))

        val recipe = RecipeParser.fromJson(RecipeParser.toJson(wellDefinedRecipe))?.copy()

        assertEquals(wellDefinedRecipe, recipe)
    }

    companion object {
        val recipeBasic = Recipe(
            title = "some-title",
            description = "some-description",
            cookTime = RecipeTime(),
            ingredients = listOf(),
            timelineSteps = listOf()
        )

        val recipeBasicJson = """
            {
              "title": "some-title",
              "description": "some-description",
              "cook_time": {},
              "ingredients": [],
              "timeline_steps": []
            }
        """.trimIndent()
    }
}