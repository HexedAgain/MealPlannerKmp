package com.example.mealplannerkmp.database.model.pojo.timeline

import com.example.mealplannerkmp.database.model.pojo.DbRecipeStep
import kotlinx.serialization.Serializable

@Serializable
data class DbRecipeTimeline(
    val start: DbTimelineStart,
    val steps: List<DbRecipeStep>
)