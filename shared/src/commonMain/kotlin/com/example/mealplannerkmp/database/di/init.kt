package com.example.mealplannerkmp.database.di

import androidx.room3.RoomDatabase
import com.example.mealplannerkmp.database.AppDatabase
import com.example.mealplannerkmp.database.getRoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getKspKoinModules(
    databaseBuilder: RoomDatabase.Builder<AppDatabase>
): List<Module> {
    return listOf(
        module {
            single<AppDatabase> {
                getRoomDatabase(databaseBuilder)
            }
        }
    )
}