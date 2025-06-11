package com.example.recetasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class FavoritosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val texto = TextView(this)
        texto.text = "Aquí aparecerán tus recetas favoritas."
        texto.textSize = 20f
        setContentView(texto)
    }
}
