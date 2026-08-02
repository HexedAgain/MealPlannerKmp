package com.example.mealplannerkmp.database.model.entity

import androidx.room3.ColumnTypeConverter
import androidx.room3.ColumnTypeConverters
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.example.mealplannerkmp.database.model.pojo.DbRecipeDifficulty
import com.example.mealplannerkmp.database.model.pojo.nutrition.DbRecipeNutrition
import com.example.mealplannerkmp.database.model.pojo.DbRecipeTime
import com.example.mealplannerkmp.database.model.pojo.timeline.DbRecipeTimeline
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

@Entity
@ColumnTypeConverters(NutritionConverter::class, TimeConverter::class, TimelineConverter::class)
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val image: String? = null,
    val video: String? = null,
    val nutrition: DbRecipeNutrition?,
    val preparationTime: DbRecipeTime? = null,
    val cookTime: DbRecipeTime,
    val difficulty: DbRecipeDifficulty,
    val serves: Int = 1,
    val ratings: Float? = null,
    val timelineSteps: List<DbRecipeTimeline>
)

class NutritionConverter {
    @ColumnTypeConverter
    fun recipeNutritionToString(value: DbRecipeNutrition): String {
        return Json.encodeToString(DbRecipeNutrition.serializer(), value)
    }

    @ColumnTypeConverter
    fun stringToRecipeNutrition(value: String): DbRecipeNutrition {
        return Json.decodeFromString(DbRecipeNutrition.serializer(), value)
    }
}

class TimeConverter {
    @ColumnTypeConverter
    fun recipeTimeToString(value: DbRecipeTime): String {
        return Json.encodeToString(DbRecipeTime.serializer(), value)
    }

    @ColumnTypeConverter
    fun stringToRecipeTime(value: String): DbRecipeTime {
        return Json.decodeFromString(DbRecipeTime.serializer(), value)
    }
}

class TimelineConverter {
    @ColumnTypeConverter
    fun recipeTimeLineToString(value: List<DbRecipeTimeline>): String {
        return Json.encodeToString(ListSerializer(DbRecipeTimeline.serializer()), value)
    }

    @ColumnTypeConverter
    fun stringToRecipeTimeLines(value: String): List<DbRecipeTimeline> {
        return Json.decodeFromString( ListSerializer(DbRecipeTimeline.serializer()), value)
    }
}
