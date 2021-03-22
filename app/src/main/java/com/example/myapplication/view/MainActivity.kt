package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.model.Animal
import com.example.myapplication.viewmodel.AnimalViewModel
import androidx.lifecycle.ViewModelProvider as ViewModelProvider1

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:AnimalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        viewModel = ViewModelProvider1(this).get(AnimalViewModel::class.java)
        viewModel.animal.observe(this, object : Observer<Animal> {
            override fun onChanged(animal: Animal?) {
                findViewById<TextView>(R.id.tvShowAnimal).text = animal?.name
            }

        })
        findViewById<Button>(R.id.btnChange).setOnClickListener {
            viewModel.saveAnimal(Animal(findViewById<EditText>(R.id.inputAnimal).text.toString()))
         }
    }

}