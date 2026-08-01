package com.example.mealplannerkmp.android

import android.app.Application
import com.example.mealplannerkmp.android.di.appModule
import com.example.mealplannerkmp.database.kspKoinModulesForAndroid
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealPlannerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val kmpModules = kspKoinModulesForAndroid(this).toTypedArray()
        startKoin {
            androidContext(this@MealPlannerApplication)
            modules(appModule, *kmpModules)
        }
    }
}