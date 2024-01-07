package com.example.kotlinavanzado1.clases

import android.app.Activity
import androidx.core.content.ContextCompat

fun String.myStyle(): String{
    return "*--$this--*"
}

//fun Activity.getColor(color: Int):Int{
//    return ContextCompat.getColor(this, color)
//}
fun Activity.getColor(color: Int) = ContextCompat.getColor(this, color)

fun Any?.isNull() = this==null