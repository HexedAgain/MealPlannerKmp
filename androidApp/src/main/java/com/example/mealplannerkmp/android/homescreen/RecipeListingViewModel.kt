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

    fun searchRecipes(

    ) {
        // this will make a network request to fetch recipes matching
    }

    fun getMyRecipes() {

    }

    fun syncLatestRecipes() {
        // this will go off to the network and get some recipes that match current ingredients
    }
}

// TODO move to somewhere more appropriate
data class SearchRecipesQuery(
    val maxCookTimeMins: Int,
    val maxDifficulty: Int,
    val availableEquipment: List<String>,
    val recipesByAuthors: List<String>,
    val precludeFoodCategories: List<String>,
    val precludeIngredients: List<String>,
    val includeIngredients: List<String>,
    val includeFoodCategories: List<String>
)