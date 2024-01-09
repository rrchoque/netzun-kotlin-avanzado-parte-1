package com.example.kotlinavanzado1.clases

class Dog (val name:String, val sex:String, weight:Float, age:Int): Animal(true, weight,age) {
    fun bark(){
        println("Woof!")
    }

    fun checkOlder(fn:(Int)->Boolean):Boolean{
        return  fn(this.age)
    }

    operator fun component1() = name
    operator fun component2() = sex
    operator fun component3() = weight
    operator fun component4() = age
}