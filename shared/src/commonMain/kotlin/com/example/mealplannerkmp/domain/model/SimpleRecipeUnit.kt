package com.example.mealplannerkmp.domain.model

interface RecipeUnit {
    val shortName: String
}

enum class SimpleRecipeUnit(override val shortName: String): RecipeUnit {
    Default(""),
    Gram("g"),
    KiloCalorie("kcal"),
    Kilogram("kg"),
    TableSpoon("tbsp"),
    Sprig("sprig"),
    Millilitre("ml")
}

sealed interface ComplexRecipeUnit: RecipeUnit {
    val qty: RecipeQuantity
    class Tin(
        override val shortName: String = "Tin",
        override val qty: RecipeQuantity
    ): ComplexRecipeUnit
}