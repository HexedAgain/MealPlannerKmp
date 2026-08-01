package com.example.mealplannerkmp.database.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import androidx.room3.Transaction
import com.example.mealplannerkmp.database.entitiy.Ingredient
import com.example.mealplannerkmp.database.entitiy.Recipe
import com.example.mealplannerkmp.database.entitiy.RecipeWithIngredients

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(item: Recipe)

    @Transaction
    @Query("Select * FROM Recipe")
    fun getAllRecipes(): List<RecipeWithIngredients>
}