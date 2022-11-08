package com.example.lsm

import android.os.Bundle
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
import java.util.Locale.filter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Dictionary : Fragment() {
    private var _binding: FragmentDictionaryBinding? = null
    private val binding get()  = _binding!!
    private lateinit var adaptercategoria : adapterCat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDictionaryBinding.inflate(inflater, container, false)
        binding.searchViewDictionary.setOnClickListener(View.OnClickListener { binding.searchViewDictionary.isIconified = false })

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriasList.sortBy { it.nombre }
        adaptercategoria = adapterCat(requireActivity(), categoriasList){
            val bundle = Bundle()
            bundle.putParcelable("categoria",it)
            Navigation.findNavController(view).navigate(R.id.action_dictionaryFragment_to_palabrasFragment,bundle)
        }

        binding.searchViewDictionary.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                filter(msg)
                return false
            }
        })


        binding.dRecycleView.adapter = adaptercategoria
        binding.dRecycleView.layoutManager = GridLayoutManager(requireActivity(),1,
            RecyclerView.VERTICAL,false)

    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<Categorias> = ArrayList<Categorias>()

        for (item in categoriasList) {
            if (item.nombre.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(activity, "No se encontraron resultados.", Toast.LENGTH_SHORT).show()
        } else {
            adaptercategoria.filterList(filteredlist)
        }
    }


}


