package com.example.mealplannerkmp.database

import androidx.room3.ConstructedBy
import androidx.room3.Database
import androidx.room3.RoomDatabase
import androidx.room3.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.mealplannerkmp.database.entitiy.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(entities = [Recipe::class], version = 1)
@ConstructedBy(AppDataBaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {
    override suspend fun clearAllTables() {
        TODO("Not yet implemented")
    }
}

@Suppress("KotlinNoActualForExpect")
expect object AppDataBaseConstructor: RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}