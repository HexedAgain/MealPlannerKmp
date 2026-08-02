package com.example.mealplannerkmp.domain.entityMapper

import com.example.mealplannerkmp.database.model.entity.IngredientEntity
import com.example.mealplannerkmp.database.model.entity.RecipeEntity
import com.example.mealplannerkmp.database.model.pojo.DbRecipeQuantity
import com.example.mealplannerkmp.database.model.pojo.DbRecipeStep
import com.example.mealplannerkmp.database.model.pojo.DbRecipeTime
import com.example.mealplannerkmp.database.model.pojo.ingredient.DbIngredient
import com.example.mealplannerkmp.database.model.pojo.ingredient.DbIngredientClass
import com.example.mealplannerkmp.database.model.pojo.ingredient.DbIngredientSet
import com.example.mealplannerkmp.database.model.pojo.nutrition.DbNutritionItem
import com.example.mealplannerkmp.database.model.pojo.nutrition.DbRecipeNutrition
import com.example.mealplannerkmp.database.model.pojo.recipeUnit.DbComplexRecipeUnit
import com.example.mealplannerkmp.database.model.pojo.recipeUnit.DbRecipeUnit
import com.example.mealplannerkmp.database.model.pojo.recipeUnit.DbSimpleRecipeUnit
import com.example.mealplannerkmp.database.model.pojo.timeline.DbRecipeTimeline
import com.example.mealplannerkmp.database.model.pojo.timeline.DbTimelineStart
import com.example.mealplannerkmp.domain.model.ComplexRecipeUnit
import com.example.mealplannerkmp.domain.model.Ingredient
import com.example.mealplannerkmp.domain.model.IngredientClass
import com.example.mealplannerkmp.domain.model.IngredientSet
import com.example.mealplannerkmp.domain.model.NutritionItem
import com.example.mealplannerkmp.domain.model.Recipe
import com.example.mealplannerkmp.domain.model.RecipeNutrition
import com.example.mealplannerkmp.domain.model.RecipeQuantity
import com.example.mealplannerkmp.domain.model.RecipeTime
import com.example.mealplannerkmp.domain.model.RecipeTimeLine
import com.example.mealplannerkmp.domain.model.RecipeUnit
import com.example.mealplannerkmp.domain.model.SimpleRecipeUnit
import com.example.mealplannerkmp.domain.model.TimeLineStart
import kotlin.enums.enumEntries

object EntityMapper {
    fun mapIngredientEntity(ingredient: Ingredient): IngredientEntity {
        return IngredientEntity(
            name = ingredient.name,
            // Note: when first entering an ingredient, these will be empty. Another process will
            // update the ingredients
            foodCategories = listOf()
        )
    }

    fun mapRecipeEntity(recipe: Recipe): RecipeEntity {
        return RecipeEntity(
            title = recipe.title,
            description = recipe.description,
            image = recipe.image,
            video = recipe.video,
            nutrition = recipe.nutrition?.toDbRecipeNutrition(),
            preparationTime = recipe.preparationTime?.toDbRecipeTime(),
            cookTime = recipe.cookTime.toDbRecipeTime(),
            difficulty = recipe.difficulty.toDbEnum(),
            serves = recipe.serves,
            ratings = recipe.ratings,
            timelineSteps = recipe.timelineSteps.map { it.toDbRecipeTimeline() },
            ingredients = recipe.ingredients.map { it.toDbIngredientSet() }
        )
    }

    private fun RecipeTimeLine.toDbRecipeTimeline(): DbRecipeTimeline {
        return DbRecipeTimeline(
            start = start.toDbTimelineStart(),
            steps = steps.map { DbRecipeStep(
                title = it.title,
                body = it.body,
                time = it.time.toDbRecipeTime()
            ) }
        )
    }

    private fun TimeLineStart.toDbTimelineStart(): DbTimelineStart {
        return when (this) {
            is TimeLineStart.AbsoluteTimeLine -> DbTimelineStart.AbsoluteTimeline(time = time.toDbRecipeTime())
            is TimeLineStart.RelativeTimeLine -> DbTimelineStart.RelativeTimeline(
                timelineRef = timelineRef,
                titleRef = titleRef,
                offset = offset.toDbRecipeTime()
            )
        }
    }

    private fun RecipeTime.toDbRecipeTime(): DbRecipeTime {
        return DbRecipeTime(
            secs = secs,
            secsLower = secsLower,
            secsUpper = secsUpper,
            mins = mins,
            minsLower = minsLower,
            minsUpper = minsUpper,
            hours = hours,
            hoursLower = hoursLower,
            hoursUpper = hoursUpper
        )
    }

    private fun IngredientClass.toDbIngredientClass(): DbIngredientClass {
        return when (this) {
            IngredientClass.Global -> DbIngredientClass.Global
            is IngredientClass.Custom -> DbIngredientClass.Custom(title)
        }
    }

    private fun IngredientSet.toDbIngredientSet(): DbIngredientSet {
        return DbIngredientSet(
            ingredientClass = ingredientClass.toDbIngredientClass(),
            ingredients = ingredients.map { it.toDbIngredient() }
        )
    }

    private fun Ingredient.toDbIngredient(): DbIngredient {
        return DbIngredient(
            name = name,
            quantity = quantity.toDbRecipeQuantity(),
            isOptional = isOptional,
            extraDetails = extraDetails
        )
    }

    private fun NutritionItem.toDbNutritionItem(): DbNutritionItem {
        return DbNutritionItem(
            type = type.toDbEnum(),
            qty = qty.toDbRecipeQuantity()
        )
    }

    private fun RecipeNutrition.toDbRecipeNutrition(): DbRecipeNutrition {
        return DbRecipeNutrition(
            items = items.map { it.toDbNutritionItem() }
        )
    }

    private fun RecipeQuantity.toDbRecipeQuantity(): DbRecipeQuantity {
        return DbRecipeQuantity(
            qty = qty,
            qtyMin = qtyMin,
            qtyMax = qtyMax,
            unit = unit.toDbRecipeUnit()
        )
    }

    private fun RecipeUnit.toDbRecipeUnit(): DbRecipeUnit {
        return when (this) {
            is SimpleRecipeUnit -> {
                // TODO This will fail if we don't add a Db mapping (in future once past mvp, we need
                //      to enforce this with unit testing). Don't want to silently take a default value
                enumEntries<DbSimpleRecipeUnit>().first { it.name == name }
            }
            else -> {
                when (this as ComplexRecipeUnit) {
                    is ComplexRecipeUnit.Tin -> DbComplexRecipeUnit.Tin(
                        shortName = shortName,
                        qty = qty.toDbRecipeQuantity()
                    )
                }
            }
        }
    }
}

// TODO We will need unit testing on these to catch missing entries. Don't want to silently default
//      anything
internal inline fun <reified S: Enum<S>, reified T: Enum<T>> S.toDbEnum(): T {
    return enumValues<T>().first { it.name == name }
}
