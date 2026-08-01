package com.example.mealplannerkmp.android.homescreen

import androidx.lifecycle.ViewModel
import com.example.mealplannerkmp.database.AppDatabase
import com.example.mealplannerkmp.database.dao.RecipeDao

class RecipeListingViewModel(
    private val appDatabase: AppDatabase,
): ViewModel() {
    fun insertRecipe() {
        val thing = appDatabase.recipeDao()
        val x = 4
    }
}