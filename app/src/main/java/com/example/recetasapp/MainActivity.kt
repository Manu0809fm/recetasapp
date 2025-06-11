package com.example.recetasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recetas = listOf(
            Receta("Arroz con Leche", "Leche, arroz, azúcar", "1. Hervir leche...\n2. Añadir arroz..."),
            Receta("Causa Limeña", "Papa amarilla, atún, limón", "1. Cocinar papa...\n2. Mezclar atún...")
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recetasRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecetaAdapter(recetas) { receta ->
            val intent = Intent(this, DetalleRecetaActivity::class.java).apply {
                putExtra("titulo", receta.titulo)
                putExtra("ingredientes", receta.ingredientes)
                putExtra("pasos", receta.pasos)
            }
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opciones, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_web -> {
                val intent = Intent(this, WebActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_acerca -> {
                Toast.makeText(this, "App de Recetas versión 1.0", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_salir -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
