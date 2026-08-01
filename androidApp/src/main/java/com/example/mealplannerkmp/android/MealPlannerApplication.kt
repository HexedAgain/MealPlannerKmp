package com.example.mealplannerkmp.android

import android.app.Application
import com.example.mealplannerkmp.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MealPlannerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MealPlannerApplication)
            modules(appModule)
        }
    }
}