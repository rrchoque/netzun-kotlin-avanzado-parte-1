package com.example.kotlinavanzado1.clases

open class Animal (var alive:Boolean, var weight:Float, var age:Int) {

    constructor():this(true, 0f, 0)

    fun die(){
        this.alive=false
    }
}