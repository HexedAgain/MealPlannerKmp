package com.example.mealplannerkmp.domain.usecase

import com.example.mealplannerkmp.database.dao.IngredientDao
import com.example.mealplannerkmp.database.dao.RecipeDao
import com.example.mealplannerkmp.domain.entityMapper.EntityMapper
import com.example.mealplannerkmp.domain.model.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class InsertRecipeUseCase(
    val scope: CoroutineScope,
    val recipeDao: RecipeDao,
    val ingredientDao: IngredientDao
) {
    operator fun invoke(recipe: Recipe) {
        scope.launch {
            val recipeEntity = EntityMapper.mapRecipeEntity(recipe = recipe)
            recipe.ingredients.forEach { ingredientSet ->
                ingredientSet.ingredients.forEach { ingredient ->
                    val ingredientEntity = EntityMapper.mapIngredientEntity(ingredient)
                    ingredientDao.insertIngredient(ingredient = ingredientEntity)
                }
            }
            recipeDao.insertRecipe(item = recipeEntity)
        }
    }
}