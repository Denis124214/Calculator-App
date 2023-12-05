package com.example.veganfood.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.veganfood.data.FoodDao
import com.example.veganfood.data.FoodEntity

@Database(entities = [FoodEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun foodDao(): FoodDao
}