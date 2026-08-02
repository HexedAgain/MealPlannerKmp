package com.example.mealplannerkmp.database.model.pojo.recipeUnit

import com.example.mealplannerkmp.database.model.pojo.DbRecipeQuantity
import kotlinx.serialization.Serializable

@Serializable
sealed interface DbComplexRecipeUnit: DbRecipeUnit {
    val qty: DbRecipeQuantity
    @Serializable
    class Tin(
        override val shortName: String = "Tin",
        override val qty: DbRecipeQuantity
    ): DbComplexRecipeUnit
}