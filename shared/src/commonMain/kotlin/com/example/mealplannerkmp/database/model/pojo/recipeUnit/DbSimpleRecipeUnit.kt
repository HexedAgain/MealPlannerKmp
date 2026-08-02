package com.example.mealplannerkmp.database.model.pojo.recipeUnit

import com.example.mealplannerkmp.database.model.pojo.DbRecipeQuantity
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

@Serializable
sealed interface DbComplexRecipeUnit: DbRecipeUnit {
    val qty: DbRecipeQuantity
    class Tin(
        override val shortName: String = "Tin",
        override val qty: DbRecipeQuantity
    ): DbComplexRecipeUnit
}
