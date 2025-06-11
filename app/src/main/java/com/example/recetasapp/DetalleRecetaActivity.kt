package com.example.recetasapp


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleRecetaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_receta)

        val titulo = intent.getStringExtra("titulo")
        val ingredientes = intent.getStringExtra("ingredientes")
        val pasos = intent.getStringExtra("pasos")

        findViewById<TextView>(R.id.txtTituloDetalle).text = titulo
        findViewById<TextView>(R.id.txtIngredientes).text = ingredientes
        findViewById<TextView>(R.id.txtPasos).text = pasos
    }
}