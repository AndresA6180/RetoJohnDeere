package com.example.lsm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lsm.databinding.ItemCategoriaBinding

class adapterCat (var context: Context, var data: List<Categorias>, private val funcionX: (Categorias) ->Unit) : RecyclerView.Adapter<adapterCat.ViewHolder>()     {

    class ViewHolder (val binding: ItemCategoriaBinding, funcionZ: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root)  {


        //Registrando el evento de click y retornando una funcion con el indice del elemento
        init {
            itemView.setOnClickListener {
                funcionZ(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCategoriaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view) {
            funcionX(data[it])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            textViewNombre.text = data[position].nombre
        }



    }

    override fun getItemCount(): Int {
        return data.size
    }
}