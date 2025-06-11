package com.example.recetasapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecetaAdapter(
    private val recetas: List<Receta>,
    private val onItemClick: (Receta) -> Unit
) : RecyclerView.Adapter<RecetaAdapter.RecetaViewHolder>() {

    inner class RecetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo = itemView.findViewById<TextView>(R.id.txtTitulo)

        fun bind(receta: Receta) {
            titulo.text = receta.titulo
            itemView.setOnClickListener { onItemClick(receta) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent, false)
        return RecetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        holder.bind(recetas[position])
    }

    override fun getItemCount(): Int = recetas.size
}
