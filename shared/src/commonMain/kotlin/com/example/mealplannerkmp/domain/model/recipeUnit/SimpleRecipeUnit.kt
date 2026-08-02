package com.example.mealplannerkmp.domain.model.recipeUnit

enum class SimpleRecipeUnit(override val shortName: String): RecipeUnit {
    Default(""),
    Gram("g"),
    KiloCalorie("kcal"),
    Kilogram("kg"),
    TableSpoon("tbsp"),
    Sprig("sprig"),
    Millilitre("ml")
}

