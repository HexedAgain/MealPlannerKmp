package com.example.mealplannerkmp.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeTimeLine(
    val start: TimeLineStart,
    val steps: List<RecipeStep>
)

@Serializable
sealed interface TimeLineStart {
    data class RelativeTimeLine(
        val timelineRef: Int,
        val titleRef: String,
        val offset: RecipeTime
    ): TimeLineStart
    data class AbsoluteTimeLine(val time: RecipeTime): TimeLineStart
}

@Serializable
data class RecipeTimeLineStart(
    val absoluteTime: Float? = null,
    val timelineRef: Int? = null,
    val titleRef: String? = null,
    val offset: RecipeTime? = null
)