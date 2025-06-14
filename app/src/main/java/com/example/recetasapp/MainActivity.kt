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
    Receta("Arroz con Leche", "Leche, arroz, azúcar, canela", "1. Hervir la leche con canela.\n2. Añadir el arroz y cocinar hasta que esté suave.\n3. Agregar el azúcar y mezclar."),
    Receta("Causa Limeña", "Papa amarilla, atún, limón, ají amarillo, mayonesa", "1. Hervir y prensar la papa.\n2. Mezclar con ají y limón.\n3. Rellenar con atún y mayonesa."),
    Receta("Lomo Saltado", "Carne de res, cebolla, tomate, papas fritas, salsa de soja", "1. Saltear la carne.\n2. Añadir cebolla y tomate.\n3. Incorporar salsa de soja y servir con papas."),
    Receta("Ají de Gallina", "Pechuga de pollo, ají amarillo, pan remojado, leche, nueces", "1. Hervir el pollo y deshilachar.\n2. Licuar ají, pan y leche.\n3. Cocinar todo junto con nueces."),
    Receta("Papa a la Huancaína", "Papa amarilla, queso fresco, ají amarillo, leche, galletas", "1. Licuar queso, ají, leche y galletas.\n2. Servir sobre papas hervidas."),
    Receta("Anticuchos", "Corazón de res, ajo, ají panca, vinagre", "1. Cortar el corazón y marinar.\n2. Ensartar en palitos.\n3. Asar y servir."),
    Receta("Pollo a la Brasa", "Pollo entero, ajo, ají panca, vinagre, comino", "1. Marinar el pollo por varias horas.\n2. Hornear o asar.\n3. Servir con papas y ensalada."),
    Receta("Tacu Tacu", "Frejoles, arroz, cebolla, huevo, plátano", "1. Mezclar arroz y frejoles.\n2. Freír en sartén.\n3. Servir con huevo frito y plátano."),
    Receta("Ceviche", "Pescado blanco, limón, cebolla, ají, cilantro", "1. Cortar el pescado en cubos.\n2. Agregar limón, cebolla y ají.\n3. Dejar reposar y servir frío."),
    Receta("Mazamorra Morada", "Maíz morado, piña, canela, clavo, azúcar, chuño", "1. Hervir el maíz con frutas y especias.\n2. Colar, añadir chuño disuelto.\n3. Cocinar hasta espesar.")
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
