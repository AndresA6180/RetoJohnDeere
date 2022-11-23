package com.example.lsm

import android.os.Bundle
import android.transition.TransitionManager
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lsm.databinding.FragmentBuscadorBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.google.android.material.transition.MaterialFade
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider


class buscadorFragment : Fragment() {
    private var _binding: FragmentBuscadorBinding? = null
    private val binding get()  = _binding!!
    private lateinit var adaptercategoria : adapterSubCategorias

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBuscadorBinding.inflate(inflater, container, false)
        enterTransition = MaterialFadeThrough().apply {
            duration = 500L
        }
        //Configurar para que el searchview pueda ser accesado en cualquier parte en vez de que solo se pueda abrir por el icono
        binding.searchViewBuscadorPalabras.setOnClickListener(View.OnClickListener { binding.searchViewBuscadorPalabras.isIconified = false })


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = requireActivity() as MainActivity
        mainActivity.bind.drawerLayout.closeDrawer(Gravity.LEFT)

        var listaCompletaPalabras : List<PalabrasRV> = emptyList()

        for (categoria in categoriasList){
            listaCompletaPalabras = listaCompletaPalabras.plus(categoria.sub_categoria)
        }

        listaCompletaPalabras.sortedBy { it.nombre }


        adaptercategoria =
            adapterSubCategorias(requireActivity(), listaCompletaPalabras) {
                //Hacer el budle para luego desplegar el video o la imagen de la palabra en el otro fragment
                val bundle = Bundle()
                bundle.putParcelable("palabra", it)
                var categoria = Categorias("buscador", emptyList(), 0)
                bundle.putParcelable("categoria", categoria)
                var name = ""

                //Si el url no viene vacio
                if(it.local_video_url.toString() != null){
                    //Obtener el nombre del archivo a abrir en el siguiente fragmento
                    var name  = resources.getResourceName(it.local_video_url.toString().toInt())
                    //Si en su nombre contiene "web" entonces es  un video y se va al fragmento con un videoView si no se
                    //va al fragmento donde tiene el imageView
                    if(name.contains("web")){
                        Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_buscadorFragment_to_videoFragment,bundle)
                    }
                    else {
                        Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_buscadorFragment_to_imagenFragment,bundle)
                    }
                }
            }

        //Si llega a buscar algo en el searchview
        binding.searchViewBuscadorPalabras.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            //Si el texto no esta vacio entonces llama la funcion de filter para hacer algo con el texto a buscar
            override fun onQueryTextChange(msg: String): Boolean {
                filter(msg, listaCompletaPalabras)
                return false
            }
        })


        binding.recycleViewPalabras.addItemDecoration( MaterialDividerItemDecoration(requireActivity(), LinearLayoutManager.VERTICAL))
        //Poner el adaptador para el recycleview
        binding.recycleViewPalabras.adapter = adaptercategoria
        binding.recycleViewPalabras.layoutManager = LinearLayoutManager(requireActivity())

    }

    //Filtrar las palabras
    private fun filter(text: String, listaCompletaPalabras: List<PalabrasRV>, ) {
        //Inicializar una lista de palabras filtradas
        val filteredlist: ArrayList<PalabrasRV> = ArrayList<PalabrasRV>()

        //Por cada elemento dentro de nuestra lista
        for (item in listaCompletaPalabras) {
            //Si el nombre del elemento contiene lo que estamos buscando agregarlo a la lista
            if (item.nombre.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }
        }
        //Si la lista esta vacio desplegar error si no entonces cambiar el recylceview y lo que contiene con
        //el metodo de filterList dentro del adaptador especifico,
        if (filteredlist.isEmpty()) {
            Toast.makeText(activity, "No se encontraron resultados.", Toast.LENGTH_SHORT).show()
        } else {
            adaptercategoria.filterList(filteredlist)
        }
    }


}