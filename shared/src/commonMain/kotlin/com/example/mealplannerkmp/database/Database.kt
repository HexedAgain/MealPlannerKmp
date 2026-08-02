package com.example.mealplannerkmp.database

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.mealplannerkmp.database.dao.IngredientDao
import com.example.mealplannerkmp.database.dao.RecipeDao
import com.example.mealplannerkmp.database.model.entity.IngredientEntity
import com.example.mealplannerkmp.database.model.entity.RecipeEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [RecipeEntity::class, IngredientEntity::class], version = 1)
//@ColumnTypeConverters(TypeConverters::class)
@ConstructedBy(AppDataBaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    abstract fun ingredientDao(): IngredientDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDataBaseConstructor: RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

//object TypeConverters {
//    @ColumnTypeConverter
//    fun recipeNutritionToString(value: RecipeNutrition): String {
//        return Json.encodeToString(RecipeNutrition.serializer(), value)
//    }
//    @ColumnTypeConverter
//    fun stringToRecipeNutrition(value: String): RecipeNutrition {
//        return Json.decodeFromString(RecipeNutrition.serializer(), value)
//    }
//
//    @ColumnTypeConverter
//    fun recipeTimeToString(value: RecipeTime): String {
//        return Json.encodeToString(RecipeTime.serializer(), value)
//    }
//
//    @ColumnTypeConverter
//    fun stringToRecipeTime(value: String): RecipeTime {
//        return Json.decodeFromString(RecipeTime.serializer(), value)
//    }
//
//    @ColumnTypeConverter
//    fun recipeTimeLinesToString(value: List<RecipeTimeLine>): String {
//        return Json.encodeToString(ListSerializer( RecipeTimeLine.serializer()), value)
//    }
//
//    @ColumnTypeConverter
//    fun stringToRecipeTimeLines(value: String): List<RecipeTimeLine> {
//        return Json.decodeFromString(ListSerializer( RecipeTimeLine.serializer()), value)
//    }
//
//    @ColumnTypeConverter
//    fun recipeQuantityToString(value: RecipeQuantity): String {
//        return Json.encodeToString(RecipeQuantity.serializer(), value)
//    }
//
//    @ColumnTypeConverter
//    fun stringToRecipeQuantity(value: String): RecipeQuantity {
//        return Json.decodeFromString(RecipeQuantity.serializer(), value)
//    }
//}