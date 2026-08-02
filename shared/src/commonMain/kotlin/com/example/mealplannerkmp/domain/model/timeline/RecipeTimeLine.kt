package com.example.mealplannerkmp.domain.model.timeline

import com.example.mealplannerkmp.domain.model.RecipeStep
import kotlinx.serialization.Serializable

@Serializable
data class RecipeTimeLine(
    val start: TimeLineStart,
    val steps: List<RecipeStep>
)

