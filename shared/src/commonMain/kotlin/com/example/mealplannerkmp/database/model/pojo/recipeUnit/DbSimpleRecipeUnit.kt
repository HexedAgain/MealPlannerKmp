package com.example.mealplannerkmp.database.model.pojo.recipeUnit

import kotlinx.serialization.Serializable

@Serializable
enum class DbSimpleRecipeUnit(override val shortName: String): DbRecipeUnit {
    Default(""),
    Gram("g"),
    KiloCalorie("kcal"),
    Kilogram("kg"),
    TableSpoon("tbsp"),
    Sprig("sprig"),
    Millilitre("ml")
}

