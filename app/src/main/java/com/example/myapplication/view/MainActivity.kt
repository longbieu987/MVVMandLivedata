package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Animal
import com.example.myapplication.viewmodel.AnimalViewModel
import androidx.lifecycle.ViewModelProvider as ViewModelProvider1

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding

    lateinit var viewModel: AnimalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)


        viewModel = ViewModelProvider1(this).get(AnimalViewModel::class.java)

        viewModel.getAnimal().observe(this, object : Observer<Animal> {
            override fun onChanged(animal: Animal?) {
                activityMainBinding.tvShowAnimal.text = animal?.name
            }

        })
       activityMainBinding.btnChange.setOnClickListener {
            viewModel.saveAnimal(Animal(activityMainBinding.inputAnimal.text.toString()))
            activityMainBinding.btnChange.setOnClickListener {
                viewModel.saveAnimal(Animal(activityMainBinding.inputAnimal.text.toString()))
            }
        }
    }
}
