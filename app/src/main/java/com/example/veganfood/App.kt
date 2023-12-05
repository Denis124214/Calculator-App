package com.example.veganfood

import android.app.Application
import androidx.room.Room
import com.example.veganfood.data.AppDatabase
import com.example.veganfood.data.FoodDao

class App : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
        lateinit var foodDao: FoodDao
    }

    override fun onCreate() {
        super.onCreate()

        appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app-db-name"
        ).allowMainThreadQueries()
            .build()

        foodDao = appDatabase.foodDao()
    }
}
