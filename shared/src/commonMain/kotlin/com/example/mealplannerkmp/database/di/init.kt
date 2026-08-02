package com.example.mealplannerkmp.database.di

import androidx.room3.RoomDatabase
import com.example.mealplannerkmp.database.AppDatabase
import com.example.mealplannerkmp.database.dao.IngredientDao
import com.example.mealplannerkmp.database.dao.RecipeDao
import com.example.mealplannerkmp.database.getRoomDatabase
import com.example.mealplannerkmp.domain.usecase.InsertRecipeUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getKspKoinModules(
    databaseBuilder: RoomDatabase.Builder<AppDatabase>
): List<Module> {
    return listOf(
        module {
            single<AppDatabase> {
                getRoomDatabase(databaseBuilder)
            }
            single<RecipeDao> {
                get<AppDatabase>().recipeDao()
            }
            single<IngredientDao> {
                get<AppDatabase>().ingredientDao()
            }
            single {
                InsertRecipeUseCase(
                    recipeDao = get(),
                    ingredientDao = get()
                )
            }
        }
    )
}