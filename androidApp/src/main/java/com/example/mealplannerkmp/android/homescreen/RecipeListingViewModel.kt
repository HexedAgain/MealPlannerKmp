package com.example.mealplannerkmp.android.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealplannerkmp.domain.model.sampleRecipe
import com.example.mealplannerkmp.domain.usecase.InsertRecipeUseCase

class RecipeListingViewModel(
    private val insertRecipeUseCase: InsertRecipeUseCase
): ViewModel() {
    fun insertRecipe() {
        insertRecipeUseCase.invoke(recipe = sampleRecipe, scope = viewModelScope)
    }
}