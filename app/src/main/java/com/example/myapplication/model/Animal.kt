package com.example.myapplication.model

class Animal(name : String) {
    var name: String = name
        // getter
        get() = field
        // setter
        set(value) {
            field = value
        }
}