package com.example.lsm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lsm.databinding.ItemJuegoBinding

//adaptador de juegos que recibe contexto, lista de categorias y funcionX
class adapterJuego(var context: Context, var data : List<Categorias>, private val funcionX: (Categorias) ->Unit) : RecyclerView.Adapter<adapterJuego.ViewHolder>(){

    class ViewHolder (val binding: ItemJuegoBinding, funcionZ: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root)  {
        //Registrando el evento de click y retornando una funcion con el indice del elemento
        init {
            itemView.setOnClickListener {
                funcionZ(adapterPosition)
            }
        }

    }

    //Crear el view holder del recycleview del juego
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemJuegoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view) {
            funcionX(data[it])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            //Aplicar el nombre de la categoria a la tarjeta
            textView8.text = data[position].nombre
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}