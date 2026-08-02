package com.example.mealplannerkmp.domain.usecase

import com.example.mealplannerkmp.database.dao.IngredientDao
import com.example.mealplannerkmp.database.dao.RecipeDao
import com.example.mealplannerkmp.domain.entityMapper.EntityMapper
import com.example.mealplannerkmp.domain.model.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class InsertRecipeUseCase(
    val recipeDao: RecipeDao,
    val ingredientDao: IngredientDao
) {
    operator fun invoke(recipe: Recipe, scope: CoroutineScope) {
        var ingredientIdCounter: Long = 0
        scope.launch {
            val recipeEntity = EntityMapper.mapRecipeEntity(id = 123, recipe = recipe)
            recipe.ingredients.forEach { ingredientSet ->
                ingredientSet.ingredients.forEach { ingredient ->
                    val ingredientEntity = EntityMapper.mapIngredientEntity(id = ingredientIdCounter++, ingredient = ingredient)
                    ingredientDao.insertIngredient(ingredient = ingredientEntity)
                }
            }
            recipeDao.insertRecipe(item = recipeEntity)
        }
    }
}