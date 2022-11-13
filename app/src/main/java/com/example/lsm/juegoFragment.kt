package com.example.lsm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lsm.databinding.FragmentDictionaryBinding
import com.example.lsm.databinding.FragmentJuegoBinding
import java.util.Locale.filter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

//Fragmento para el juego
class juegoFragment : Fragment() {
    private var _binding: FragmentJuegoBinding? = null
    private val binding get()  = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJuegoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Ordenar la lista de categorias
        categoriasList.sortBy { it.nombre }
        //Crear adaptador para el juego
        val adapterJuego = adapterJuego(requireActivity(), categoriasList){
            //Poner en un bundle la categoria para poder navegar despues a lo que viene siendo
            //la evaluacion con la categoria
            val bundle = Bundle()
            bundle.putParcelable("categoria",it)
        }

        //Poner al recycleView el adaptador
        binding.recycleViewJuego.adapter = adapterJuego
        //Hacer que el recycleview despliege de dos en dos
        binding.recycleViewJuego.layoutManager = GridLayoutManager(requireActivity(),2,
            RecyclerView.VERTICAL,false)

    }

}