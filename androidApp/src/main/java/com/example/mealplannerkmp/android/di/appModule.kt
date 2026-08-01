package com.example.mealplannerkmp.android.di

import com.example.mealplannerkmp.android.homescreen.RecipeListingViewModel
import com.example.mealplannerkmp.database.AppDatabase
import com.example.mealplannerkmp.database.dao.RecipeDao
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    viewModel {
        RecipeListingViewModel(appDatabase = get<AppDatabase>())
    }
}