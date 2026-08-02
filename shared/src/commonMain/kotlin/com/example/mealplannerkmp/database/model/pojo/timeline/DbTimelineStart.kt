package com.example.mealplannerkmp.database.model.pojo.timeline

import com.example.mealplannerkmp.database.model.pojo.DbRecipeTime
import com.example.mealplannerkmp.domain.model.RecipeTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface DbTimelineStart {
    @Serializable
    data class RelativeTimeline(
        val timelineRef: Int,
        val titleRef: String,
        val offset: DbRecipeTime
    ): DbTimelineStart
    @Serializable
    data class AbsoluteTimeline(val time: DbRecipeTime): DbTimelineStart
}