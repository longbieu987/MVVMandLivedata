package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.Animal
import com.example.myapplication.preferences.PreferencesManager
import java.util.*

class AnimalViewModel(application: Application) : AndroidViewModel(application) {
    private var preferencesManager: PreferencesManager = PreferencesManager(application)
    private var data: MutableLiveData<Animal> = MutableLiveData()

    fun getAnimal(): MutableLiveData<Animal> {
        data.value = preferencesManager.getAnimal()
        return data
    }

    fun saveAnimal(animal: Animal) {
        data.value = animal
        data.value?.let { preferencesManager.saveAnimal(it) }
    }
}