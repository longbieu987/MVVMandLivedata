package com.example.myapplication.viewmodel;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Animal;
import com.example.myapplication.preferences.PreferencesManager;

import java.util.Objects;

public class AnimalViewModel extends AndroidViewModel {
    private static PreferencesManager preferencesManager;
    private MutableLiveData<Animal> data = new MutableLiveData<Animal>();

    public AnimalViewModel(Application application) {
        super(application);
        if(preferencesManager == null){
            preferencesManager = new PreferencesManager(application);
        }
    }
        public MutableLiveData<Animal> getAnimal(){
            data.setValue(preferencesManager.getAnimal());
            return data;
        }
        public void saveAnimal(Animal animal){
            data.setValue(animal);
            preferencesManager.saveAnimal(Objects.requireNonNull(data.getValue()));
        }
}
