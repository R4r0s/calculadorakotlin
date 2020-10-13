package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun exitApp(view: View) {
        finish()
    }

    fun continueApp(view: View) {

        var editName = findViewById<EditText>(R.id.editTextTextPersonName2)
        var name = editName.text.toString()
        var miIntent = Intent(this, calc::class.java)
        miIntent.putExtra("nombre", name)
        startActivity(miIntent)
    }
}