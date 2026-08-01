package com.example.mealplannerkmp.database.di

import com.example.mealplannerkmp.database.AppDatabase
import com.example.mealplannerkmp.database.getRoomDatabase
import org.koin.dsl.module

// I now need to figure out how this module is gonna get access to the builder. I imagine the
// different platforms are going to have to provide it
val databaseModule = module {
//    single<AppDatabase> {
//        getRoomDatabase()
//    }
}