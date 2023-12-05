package com.example.veganfood.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow // браво chat gpt

@Dao
interface FoodDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(foodEntity: FoodEntity)
    @Delete
    suspend fun deleteItem(nameEntity: FoodEntity)
    @Query("SELECT * FROM name_table")
    fun getAllItems(): Flow<List<FoodEntity>>

    @Query("SELECT * FROM name_table")
    fun getAllLiveData(): LiveData<List<FoodEntity>>
}