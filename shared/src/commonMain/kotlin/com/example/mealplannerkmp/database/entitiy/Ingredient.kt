package com.example.mealplannerkmp.database.entitiy

import androidx.room3.Embedded
import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.PrimaryKey
import com.example.mealplannerkmp.model.RecipeQuantity

@Entity
data class Ingredient(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    // FIXME - this needs to be a relation
//    @Embedded val categories: List<IngredientCategory>
)

// Actually some ingredients have several categories: Cheddar -> [Cheese, Dairy], I will want to be
// querying or filtering by these when looking up recipes (i.e get me stuff I can eat that doesn't
// have cheese in it)
//@Entity
//data class IngredientCategory(
//    @PrimaryKey(autoGenerate = true) val id: Long,
//    val name: String
//)

@Entity(
    primaryKeys = ["recipeId", "ingredientId"],
    foreignKeys = [
        ForeignKey(
            entity = Recipe::class,
            parentColumns = ["id"],
            childColumns = ["recipeId"]
        ),
        ForeignKey(
            entity = Ingredient::class,
            parentColumns = ["id"],
            childColumns = ["ingredientId"]
        )
    ]
)
data class RecipeIngredient(
    val recipeId: Long,
    val ingredientId: Long,
    @Embedded val quantity: RecipeQuantity // will use type convertor
)