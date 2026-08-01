package com.example.mealplannerkmp.database.dao

import androidx.room3.Dao
import androidx.room3.Insert
import com.example.mealplannerkmp.database.entitiy.Recipe

@Dao
interface RecipeDao {
    @Insert
    suspend fun insertRecipe(item: Recipe)
}