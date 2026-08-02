package com.example.mealplannerkmp.android.di

import com.example.mealplannerkmp.android.homescreen.RecipeListingViewModel
import com.example.mealplannerkmp.database.AppDatabase
import com.example.mealplannerkmp.database.dao.IngredientDao
import com.example.mealplannerkmp.database.dao.RecipeDao
import com.example.mealplannerkmp.database.getDatabaseBuilder
import com.example.mealplannerkmp.database.getRoomDatabase
import com.example.mealplannerkmp.domain.usecase.InsertRecipeUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    viewModel {
        RecipeListingViewModel(insertRecipeUseCase = get())
    }
}