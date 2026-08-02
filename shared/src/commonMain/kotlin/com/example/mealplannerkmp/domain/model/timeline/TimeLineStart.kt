package com.example.mealplannerkmp.domain.model.timeline

import com.example.mealplannerkmp.domain.model.RecipeTime
import kotlinx.serialization.Serializable

@Serializable
sealed interface TimeLineStart {
    data class RelativeTimeLine(
        val timelineRef: Int,
        val titleRef: String,
        val offset: RecipeTime
    ): TimeLineStart
    data class AbsoluteTimeLine(val time: RecipeTime): TimeLineStart
}