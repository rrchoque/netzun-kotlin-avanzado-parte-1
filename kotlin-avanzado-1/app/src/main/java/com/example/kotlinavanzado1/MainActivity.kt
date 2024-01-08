package com.example.kotlinavanzado1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.kotlinavanzado1.clases.Dog
import com.example.kotlinavanzado1.clases.isNull
import com.example.kotlinavanzado1.clases.show

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

        /**
         * Funciones de orden superior en objetos
         */
        val firulais = Dog("Firulais", "Macho", 6.7f, 6)
        if (firulais.checkOlder(::inPeru)) println("${firulais.name} es mayor de edad en Perú")
        if (firulais.checkOlder(::inBolivia)) println("${firulais.name} es mayor de edad en Bolivia")
        if (firulais.checkOlder(::inSpain)) println("${firulais.name} es mayor de edad en España")

        /**
         * Funciones Lambda
         */

        var funcion = {x:Int, y:Int -> x+y}
        var resultado4:Int = calculadora(4,6,funcion)
        println("Resultado suma con variable función es: $resultado4")

        funcion = {x:Int, y:Int -> x-y}
        resultado4 = calculadora(4,6,funcion)
        println("Resultado resta con variable función es: $resultado4")

        funcion = {x:Int, y:Int -> x*y}
        resultado4 = calculadora(4,6,funcion)
        println("Resultado multiplicación con variable función es: $resultado4")


        resultado4 = calculadora(4,6) { x: Int, y: Int -> x + y }
        println("Resultado suma con función lambda es: $resultado4")

        resultado4 = calculadora(4,6) {
            x: Int, y: Int ->
                var result=1
                for (i in 1 ..y){
                    result *= x
                }
            result
        }
        println("Resultado potencia con función lambda es: $resultado4")

        var miArray = IntArray(5){it*2}
        miArray.show()
        println()

        var miArray2 = IntArray(5){it*5}
        miArray2.show()
        println()

        var tvTexto = findViewById<TextView>(R.id.tvTexto)
        tvTexto.setOnClickListener {
            Toast.makeText(this, "Mensajito", Toast.LENGTH_SHORT).show()
        }

        // Acceso a variables fuera de la función lambda
        var suma:Int = 0
        runArray(miArray){
            it->
            suma += it
        }
        println("Suma de elementos del array: $suma")
    }

    private fun calculadora(num1: Int, num2:Int, fn:(Int, Int) -> Int):Int{
        return fn(num1, num2)
    }

    private fun suma(a: Int, b:Int):Int = a+b
    private fun resta(a: Int, b:Int):Int = a-b
    private fun multiplicacion(a: Int, b:Int):Int = a*b

    //---------------

    private fun inPeru(age:Int):Boolean = age >= 6
    private fun inBolivia(age:Int):Boolean = age >= 5
    private fun inSpain(age:Int):Boolean = age >= 7

    //------
    private fun runArray(array:IntArray, fn:(Int)->Unit){
        for (i in array){
            fn(i)
        }
    }
}