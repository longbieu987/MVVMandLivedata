package com.example.myapplication.preferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Animal;

public class PreferencesManager {

    private static LiveData<Animal> animal;
    public static final String SHARED_PREFENCES_NAME = "preferences";
    public static final String SHARED_PREFENCES_KEY_ANIMAL_NAME = "animal_name";
    private static SharedPreferences sharedPreferences;

    public PreferencesManager(Application application) {
        if (sharedPreferences == null){
            sharedPreferences = application.getSharedPreferences(SHARED_PREFENCES_NAME,Context.MODE_PRIVATE);
        }
    }
    public void saveAnimal(Animal animal){
        sharedPreferences.edit().putString(SHARED_PREFENCES_KEY_ANIMAL_NAME, animal.getName()).apply();
    }
    public Animal getAnimal(){
        return new Animal(sharedPreferences.getString(SHARED_PREFENCES_KEY_ANIMAL_NAME,"Trống")) ;
    }

}
