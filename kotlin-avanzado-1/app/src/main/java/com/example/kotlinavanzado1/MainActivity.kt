package com.example.kotlinavanzado1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.kotlinavanzado1.clases.Dog
import com.example.kotlinavanzado1.clases.isNull

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Funciones de Extensión
         */

        var perro = Dog("Perla", "Hembra", 12.0f, 9)
        perro.bark()

        val miVar: String = "Reynaldo"

        fun String.myStyle():String{
            return "*--$this--*"
        }

        val miVar2 = miVar.myStyle()

        println(miVar2)

        ContextCompat.getColor(this, R.color.black)
        ContextCompat.getColor(this, R.color.white)

        var codigo:String? = "123"
        var resultado = codigo.isNull()
        println("Resultado: $resultado")
        
    }
}