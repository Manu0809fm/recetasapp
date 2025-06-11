package com.example.recetasapp
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AcercaDeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val texto = TextView(this)
        texto.text = "App de Recetas\nVersión 1.0\nDesarrollada por TuNombre"
        texto.textSize = 18f
        setContentView(texto)
    }
}
