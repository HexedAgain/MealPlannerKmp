package com.example.mealplannerkmp.domain.model.recipeUnit

import com.example.mealplannerkmp.domain.model.RecipeQuantity

sealed interface ComplexRecipeUnit: RecipeUnit {
    val qty: RecipeQuantity
    class Tin(
        override val shortName: String = "Tin",
        override val qty: RecipeQuantity
    ): ComplexRecipeUnit
}