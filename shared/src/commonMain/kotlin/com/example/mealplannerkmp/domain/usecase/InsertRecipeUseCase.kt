package com.example.mealplannerkmp.domain.usecase

import com.example.mealplannerkmp.database.dao.IngredientDao
import com.example.mealplannerkmp.database.dao.RecipeDao
import com.example.mealplannerkmp.database.model.entity.RecipeEntity
import com.example.mealplannerkmp.domain.model.Recipe
import kotlinx.coroutines.CoroutineDispatcher

class InsertRecipeUseCase(
    val dispatcher: CoroutineDispatcher,
    val recipeDao: RecipeDao,
    val ingredientDao: IngredientDao
) {
    operator suspend fun invoke(recipe: Recipe) {
//        val dbRecipe = recipe.toDbRecipe()
//        recipeDao.insertRecipeWithIngredients()
    }

//    private fun Recipe.toDbRecipe(): RecipeEntity {
//        return RecipeEntity(
//            title = title,
//            description = description,
//            image = image,
//            video = video,
//            nutrition = nutrition,
//            preparationTime = preparationTime,
//            cookTime = cookTime,
//            difficulty = difficulty,
//            serves = serves,
//            ratings = ratings,
//            timelineSteps = timelineSteps
//        )
//    }
//
//    private fun Recipe.toDbIngredients(): List<RecipeIngredient> {
//        return listOf()
//    }
}