package com.example.mealplannerkmp.domain.model.timeline

import com.example.mealplannerkmp.domain.model.RecipeTime
import kotlinx.serialization.Serializable

@Serializable
data class RecipeTimeLineStart(
    val absoluteTime: Float? = null,
    val timelineRef: Int? = null,
    val titleRef: String? = null,
    val offset: RecipeTime? = null
)