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
import java.net.URLConnection
import java.util.Locale.filter


class palabras : Fragment() {
    private var _binding: FragmentPalabrasBinding? = null
    private val binding get()  = _binding!!
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
        binding.searchViewWords.setOnClickListener(View.OnClickListener { binding.searchViewWords.isIconified = false })

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            categoria = it.get("categoria") as Categorias

            activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // in here you can do logic when backPress is clicked
                    Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_palabrasFragment_to_dictionaryFragment)
                }
            })

            categoria.sub_categoria.sortedBy { it.nombre }
            adaptercategoria =
                adapterSubCategorias(requireActivity(), categoria.sub_categoria) {
                    val bundle = Bundle()
                    bundle.putParcelable("palabra", it)
                    bundle.putParcelable("categoria", categoria)
                    var name = ""

                    if(it.local_video_url.toString() != null){
                        var name  = resources.getResourceName(it.local_video_url.toString().toInt())
                        if(name.contains("web")){
                            Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_palabrasFragment_to_videoFragment,bundle)
                        }
                        else {
                            Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_palabrasFragment_to_imagenFragment,bundle)
                        }
                    }


                }

            binding.searchViewWords.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
                android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(msg: String): Boolean {
                    filter(msg)
                    return false
                }
            })


            binding.dRecycleView.addItemDecoration( MaterialDividerItemDecoration(requireActivity(), LinearLayoutManager.VERTICAL))
            binding.dRecycleView.adapter = adaptercategoria
            binding.dRecycleView.layoutManager = LinearLayoutManager(requireActivity())

        }
    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<PalabrasRV> = ArrayList<PalabrasRV>()

        for (item in categoria.sub_categoria) {
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