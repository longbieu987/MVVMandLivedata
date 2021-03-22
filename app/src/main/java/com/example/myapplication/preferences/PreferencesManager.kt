package com.example.myapplication.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.model.Animal

class PreferencesManager(application: Application) {
    val SHARED_PREFENCES_NAME = "preferences"
    val SHARED_PREFENCES_KEY_ANIMAL_NAME = "animal_name"
    private var sharedPreferences: SharedPreferences? = null

    init {
        if (sharedPreferences == null) {
            sharedPreferences = application.getSharedPreferences(SHARED_PREFENCES_NAME, Context.MODE_PRIVATE)
        }
    }

    fun saveAnimal(animal: Animal) {
        sharedPreferences!!.edit().putString(SHARED_PREFENCES_KEY_ANIMAL_NAME, animal.name).apply()
    }

    fun getAnimal(): Animal {
        return Animal(sharedPreferences!!.getString(SHARED_PREFENCES_KEY_ANIMAL_NAME,"Trống")!!)
    }
}