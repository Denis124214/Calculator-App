package com.example.veganfood.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.veganfood.App

class MainViewModel : ViewModel() {

    // Используйте прямое обращение к свойству без создания дополнительного метода
    val foodLiveData: LiveData<List<FoodEntity>> = App.appDatabase.foodDao().getAllLiveData()
}
