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
        categoriasList.sortBy { it.nombre }
        val adapterJuego = adapterJuego(requireActivity(), categoriasList){
            val bundle = Bundle()
            bundle.putParcelable("categoria",it)
        }


        binding.recycleViewJuego.adapter = adapterJuego
        binding.recycleViewJuego.layoutManager = GridLayoutManager(requireActivity(),2,
            RecyclerView.VERTICAL,false)

    }

}