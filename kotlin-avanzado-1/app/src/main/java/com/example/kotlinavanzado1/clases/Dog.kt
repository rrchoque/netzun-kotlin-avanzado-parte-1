package com.example.kotlinavanzado1.clases

class Dog (val name:String, val sex:String, weight:Float, age:Int): Animal(true, weight,age) {
    fun bark(){
        println("Woof!")
    }

    fun checkOlder(fn:(Int)->Boolean):Boolean{
        return  fn(this.age)
    }
}