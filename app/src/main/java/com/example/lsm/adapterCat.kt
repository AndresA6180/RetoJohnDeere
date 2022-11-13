package com.example.lsm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lsm.databinding.ItemCategoriaBinding
//adaptador de categorias que recibe contexto, lista de categorias y funcionX
class adapterCat (var context: Context, var data: List<Categorias>, private val funcionX: (Categorias) ->Unit) : RecyclerView.Adapter<adapterCat.ViewHolder>()     {

    class ViewHolder (val binding: ItemCategoriaBinding, funcionZ: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root)  {

        //Registrando el evento de click y retornando una funcion con el indice del elemento
        init {
            itemView.setOnClickListener {
                funcionZ(adapterPosition)
            }
        }

    }

    //Cuando se crea el viewHolder de la categoria
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCategoriaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //Retornar con el dato en especifico
        return ViewHolder(view) {
            funcionX(data[it])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            //Agregar la imagen a cada categoria
            Glide.with(context).load(data[position].url_imagen).into(imageView)
            //Agregar el texto a cada categoria
            textViewNombre.text = data[position].nombre
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    fun filterList(filterlist: ArrayList<Categorias>) {
        //Filtrar la lista. Recibe lista filtrada y la pone como el nuevo source y notifica que hubo un cambio
        data = filterlist
        notifyDataSetChanged()
    }

}