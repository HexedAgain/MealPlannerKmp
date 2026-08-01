package com.example.mealplannerkmp.android.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun RecipeListing(recipeListingViewModel: RecipeListingViewModel = koinViewModel()) {
    recipeListingViewModel.insertRecipe()
    Column {
        Recipe()
    }
}

fun Recipe() {

}