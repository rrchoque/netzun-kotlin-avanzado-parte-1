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

        /**
         * Funciones de orden superior
         */

        val resultado1:Int = calculadora(4,6, ::suma)
        println("Resultado Suma: $resultado1")

        val resultado2:Int = calculadora(4,6, ::resta)
        println("Resultado Resta: $resultado2")

        val resultado3:Int = calculadora(4,6, ::multiplicacion)
        println("Resultado Multiplicación: $resultado3")
    }

    private fun calculadora(num1: Int, num2:Int, fn:(Int, Int) -> Int):Int{
        return fn(num1, num2)
    }

    private fun suma(a: Int, b:Int):Int = a+b
    private fun resta(a: Int, b:Int):Int = a-b
    private fun multiplicacion(a: Int, b:Int):Int = a*b
}