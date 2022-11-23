package com.example.lsm

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lsm.databinding.FragmentDictionaryBinding
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFade
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider
import java.util.Locale.filter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Dictionary : Fragment() {
    //Bindings del fragmento de diccionario
    private var _binding: FragmentDictionaryBinding? = null
    private val binding get()  = _binding!!
    //Definir el adapatador de la categoria
    private lateinit var adaptercategoria : adapterCat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDictionaryBinding.inflate(inflater, container, false)

        enterTransition = MaterialFadeThrough().apply {
            duration = 500L
        }

        //Configurar para que el searchview pueda ser accesado en cualquier parte en vez de que solo se pueda abrir por el icono
        binding.searchViewDictionary.setOnClickListener(View.OnClickListener { binding.searchViewDictionary.isIconified = false })

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = requireActivity() as MainActivity
        mainActivity.bind.drawerLayout.closeDrawer(Gravity.LEFT)
        //Hacer que toda la lista de categorias este organizada
        categoriasList.sortBy { it.nombre }
        //Poner el adaptador con el contexto y la lista organizada
        adaptercategoria = adapterCat(requireActivity(), categoriasList){
            //Hacer un bundle para pasar la categoria seleccionada
            val bundle = Bundle()
            bundle.putParcelable("categoria",it)
            //Poder navegar hacia el fragmento que es de las palabras con el bundle conteniendo la categoria especifica
            Navigation.findNavController(view).navigate(R.id.action_dictionaryFragment_to_palabrasFragment,bundle)
        }

        //Hacer metodo para cuando se busque algo en el searchview
        binding.searchViewDictionary.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            //Si no se hizo nada regresar falso
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                //Llamar al metodo filter dentro de esta clase para hacer algo con el mensaje
                filter(msg)
                return false
            }
        })

        //Definir al adaptador del recycleview
        binding.dRecycleView.adapter = adaptercategoria
        //Poner el recycleview de 1 por 1
        binding.dRecycleView.layoutManager = GridLayoutManager(requireActivity(),1,
            RecyclerView.VERTICAL,false)

    }

    //Funcion para filtrar lo que viene dentro del searchview
    private fun filter(text: String) {
        //Inicializar la nueva lista de categorias filtradas
        val filteredlist: ArrayList<Categorias> = ArrayList<Categorias>()

        //Por cada objeto dentro de la lista de categorias
        for (item in categoriasList) {
            //Si el objeto contiene el texto que se busca
            if (item.nombre.toLowerCase().contains(text.toLowerCase())) {
                //Agregar a la lista de filtrados el objeto que tiene el texto nuevo en su nombre
                filteredlist.add(item)
            }
        }
        //Si no hay nada que concuerde desplegar mensaje de error
        if (filteredlist.isEmpty()) {
            Toast.makeText(activity, "No se encontraron resultados.", Toast.LENGTH_SHORT).show()
        } else {
            //Si hay objetos que concuerdan entonces poner la nueva lista como el source del data en el adaptador
            adaptercategoria.filterList(filteredlist)
        }
    }


}


