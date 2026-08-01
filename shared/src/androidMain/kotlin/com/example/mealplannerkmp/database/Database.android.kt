package com.example.mealplannerkmp.database

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.mealplannerkmp.database.di.getKspKoinModules
import org.koin.core.module.Module

// android is going to call this from application class and provide it to, say, initialiseKoin
fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("mealPlanner.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}

fun kspKoinModulesForAndroid(appContext: Context): List<Module> {
    return getKspKoinModules(
        databaseBuilder = getDatabaseBuilder(appContext)
    )
}
