package com.example.mealplannerkmp.database.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import com.example.mealplannerkmp.database.model.entity.IngredientEntity

@Dao
interface IngredientDao {
    // Using ignore here, because first time we insert, it will have no food categories. Another
    // process (possibly us via an admin page) will be adding those categories
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertIngredient(ingredient: IngredientEntity)
}