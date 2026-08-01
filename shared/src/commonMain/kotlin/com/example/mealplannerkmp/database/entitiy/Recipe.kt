package com.example.mealplannerkmp.database.entitiy

import androidx.room3.ColumnTypeConverters
import androidx.room3.Embedded
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import androidx.room3.Relation
import com.example.mealplannerkmp.database.TypeConverters
import com.example.mealplannerkmp.model.RecipeDifficulty
import com.example.mealplannerkmp.model.RecipeNutrition
import com.example.mealplannerkmp.model.RecipeTime
import com.example.mealplannerkmp.model.RecipeTimeLine

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val image: String? = null,
    val video: String? = null,
    val nutrition: RecipeNutrition,
    val preparationTime: RecipeTime? = null,
    val cookTime: RecipeTime,
    val difficulty: RecipeDifficulty = RecipeDifficulty.Easy,
    val serves: Int = 1,
    val ratings: Float? = null,
    val timelineSteps: List<RecipeTimeLine>
)

@Entity
data class RecipeWithIngredients(
    @Embedded val recipe: Recipe,

    @Relation(
        parentColumns = ["id"],
        entityColumns = ["recipeId"]
    )
    val ingredients: List<RecipeIngredient>
)