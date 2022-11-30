package com.example.lsm

import android.R.attr.actionBarItemBackground
import android.R.attr.path
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lsm.databinding.FragmentPalabrasBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.google.android.material.transition.MaterialFadeThrough
import java.net.URLConnection
import java.util.Locale.filter


class palabras : Fragment() {
    //Binding para las palabras
    private var _binding: FragmentPalabrasBinding? = null
    private val binding get() = _binding!!
    //Adaptador para subcategoria (palabras)
    private lateinit var adaptercategoria : adapterSubCategorias
    private  lateinit var categoria : Categorias
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // The callback can be enabled or disabled here or in the lambda
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPalabrasBinding.inflate(inflater, container, false)
        //Hacer que searchview no solo se tenga que picar en el icono si no que toda la barra sea util
        binding.searchViewWords.setOnClickListener(View.OnClickListener { binding.searchViewWords.isIconified = false })
        enterTransition = MaterialFadeThrough().apply {
            duration = 500L
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Obtener el bundle
        arguments?.let {
            //Obtener la categoria seleccionada
            categoria = it.get("categoria") as Categorias

            //Si el usuario escoge regresar al fragmento pasado
            activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Navegar a lo que viene siendo el diccionario
                    Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_palabrasFragment_to_dictionaryFragment)
                }
            })

            //Organizar la lista de palabras
            categoria.sub_categoria.sortedBy { it.nombre }
            //Crear el adaptador
            adaptercategoria =
                adapterSubCategorias(requireActivity(), categoria.sub_categoria) {
                    //Hacer el budle para luego desplegar el video o la imagen de la palabra en el otro fragment
                    val bundle = Bundle()
                    bundle.putParcelable("palabra", it)
                    bundle.putParcelable("categoria", categoria)
                    var name = ""

                    //Si el url no viene vacio
                    if(it.local_video_url.toString() != null){
                        //Obtener el nombre del archivo a abrir en el siguiente fragmento
                        var name  = resources.getResourceName(it.local_video_url.toString().toInt())
                        //Si en su nombre contiene "web" entonces es  un video y se va al fragmento con un videoView si no se
                        //va al fragmento donde tiene el imageView
                        if(name.contains("web")){
                            Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_palabrasFragment_to_videoFragment,bundle)
                        }
                        else {
                            Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_palabrasFragment_to_imagenFragment,bundle)
                        }
                    }


                }

            //Si llega a buscar algo en el searchview
            binding.searchViewWords.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                //Si el texto no esta vacio entonces llama la funcion de filter para hacer algo con el texto a buscar
                override fun onQueryTextChange(msg: String): Boolean {
                    filter(msg)
                    return false
                }
            })


            //Agregar divisiones entre cada palabra
            binding.dRecycleView.addItemDecoration( MaterialDividerItemDecoration(requireActivity(), LinearLayoutManager.VERTICAL))
            //Poner el adaptador para el recycleview
            binding.dRecycleView.adapter = adaptercategoria
            binding.dRecycleView.layoutManager = LinearLayoutManager(requireActivity())

        }
    }

    //Filtrar las palabras
    private fun filter(text: String) {
        //Inicializar una lista de palabras filtradas
        val filteredlist: ArrayList<PalabrasRV> = ArrayList<PalabrasRV>()

        //Por cada elemento dentro de nuestra lista
        for (item in categoria.sub_categoria) {
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