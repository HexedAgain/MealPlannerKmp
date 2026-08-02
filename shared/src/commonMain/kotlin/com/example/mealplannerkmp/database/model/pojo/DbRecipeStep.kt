package com.example.mealplannerkmp.database.model.pojo

import kotlinx.serialization.Serializable

@Serializable
class DbRecipeStep (
    val title: String,
    val body: String,
    val time: DbRecipeTime
)