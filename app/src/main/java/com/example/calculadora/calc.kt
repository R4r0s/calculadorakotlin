package com.example.calculadora


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calc.*


class calc : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        var name: String = intent.getStringExtra("nombre").toString()
        var miTextView = findViewById<TextView>(R.id.textView)
        miTextView.text = "Hola " + name
        Resultado.text = "0"
        operacion = SIN_OPERACION

        Uno.setOnClickListener { numberPressed("1") }
        Dos.setOnClickListener { numberPressed("2") }
        Tres.setOnClickListener { numberPressed("3") }
        Cuatro.setOnClickListener { numberPressed("4") }
        Cinco.setOnClickListener { numberPressed("5") }
        Seis.setOnClickListener { numberPressed("6") }
        Siete.setOnClickListener { numberPressed("7") }
        Ocho.setOnClickListener { numberPressed("8") }
        Nueve.setOnClickListener { numberPressed("9") }
        Cero.setOnClickListener { numberPressed("0") }

        BorrarTodo.setOnClickListener { resetAll() }

        Sumar.setOnClickListener { operationPressed(SUMA) }
        Restar.setOnClickListener { operationPressed(RESTA) }
        Multiplicar.setOnClickListener { operationPressed(MULTIPLICACION) }
        Dividir.setOnClickListener { operationPressed(DIVISION) }

        Igual.setOnClickListener { resolvePressed() }
    }

    private fun numberPressed(num: String){
        if(Resultado.text == "0" && num != ".") {
            Resultado.text = "$num"
        } else {
            Resultado.text = "${Resultado.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = Resultado.text.toString().toDouble()
        } else {
            num2 = Resultado.text.toString().toDouble()
        }
    }

    private fun operationPressed(operacion: Int){
        this.operacion = operacion
        num1 = Resultado.text.toString().toDouble()

        Resultado.text = "0"
    }

    private fun resolvePressed(){

        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }

        num1 = result as Double

        Resultado.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    private fun resetAll(){
        Resultado.text = "0"
        num1 = 0.0
        num2 = 0.0
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }
    }


