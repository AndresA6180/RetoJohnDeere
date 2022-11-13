package com.example.lsm

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lsm.databinding.ItemSubcategoriasBinding

//adaptador de categorias que recibe contexto, lista de palabras y funcionX
class adapterSubCategorias (var context: Context, var data: List<PalabrasRV>, private val funcionX: (PalabrasRV) ->Unit) : RecyclerView.Adapter<adapterSubCategorias.ViewHolder>()     {

    class ViewHolder (val binding: ItemSubcategoriasBinding, funcionZ: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root)  {


        //Registrando el evento de click y retornando una funcion con el indice del elemento
        init {
            itemView.setOnClickListener {
                funcionZ(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSubcategoriasBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view) {
            funcionX(data[it])
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            //Agregar el texto del nombre de la palabra a la tarjeta en el recycleview
            textViewPalabras.text = data[position].nombre
        }



    }

    override fun getItemCount(): Int {
        return data.size
    }

    //Filtrar las palabras
    fun filterList(filterlist: ArrayList<PalabrasRV>) {
        //Recibir lista filtrada y poner la como nuevo source de data
        data = filterlist
        //Notificar que hubo cambios
        notifyDataSetChanged()
    }
}