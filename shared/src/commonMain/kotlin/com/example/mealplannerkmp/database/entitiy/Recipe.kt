package com.example.mealplannerkmp.database.entitiy

import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true) val id: Long = 0
) {
}