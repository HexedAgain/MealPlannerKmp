package com.example.mealplannerkmp.database.model.pojo

import kotlinx.serialization.Serializable

// obviously need more of these
@Serializable
enum class DbFoodCategory {
    Dairy,
    Cheese,
    Meat,
    Unknown
}