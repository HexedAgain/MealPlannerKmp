package com.example.mealplannerkmp.database.model.pojo.ingredient

import kotlinx.serialization.Serializable

// does this need to be sealed!?
@Serializable
sealed interface DbIngredientClass {
    data object Global: DbIngredientClass
    class Custom(val title: String): DbIngredientClass
}