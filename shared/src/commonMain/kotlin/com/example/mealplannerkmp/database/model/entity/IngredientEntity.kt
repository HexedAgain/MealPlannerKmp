package com.example.mealplannerkmp.database.model.entity

import androidx.room3.ColumnTypeConverter
import androidx.room3.ColumnTypeConverters
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.example.mealplannerkmp.database.model.pojo.DbFoodCategory
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

@Entity
@ColumnTypeConverters(FoodCategoryConverter::class)
data class IngredientEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val foodCategories: List<DbFoodCategory>,
)

class FoodCategoryConverter {
    @ColumnTypeConverter
    fun foodCategoryToString(value: List<DbFoodCategory>): String {
        return Json.encodeToString(ListSerializer( DbFoodCategory.serializer()), value)
    }

    @ColumnTypeConverter
    fun stringToFoodCategory(value: String): List<DbFoodCategory> {
        return Json.decodeFromString(ListSerializer(DbFoodCategory.serializer()), value)
    }
}