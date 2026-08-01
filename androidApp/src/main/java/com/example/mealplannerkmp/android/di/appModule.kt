package com.example.mealplannerkmp.android.di

import com.example.mealplannerkmp.android.homescreen.RecipeListingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        RecipeListingViewModel()
    }
}