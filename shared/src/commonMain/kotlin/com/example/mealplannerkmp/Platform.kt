package com.example.mealplannerkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform