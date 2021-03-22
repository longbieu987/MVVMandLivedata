package com.example.myapplication.model

import android.util.Log

class Animal(name : String) {
var name: String = name
    // getter
    get() = field
    // setter
    set(value) {
        field = value
    }
}