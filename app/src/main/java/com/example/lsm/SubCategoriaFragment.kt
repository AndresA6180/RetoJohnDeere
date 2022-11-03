package com.example.lsm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lsm.databinding.FragmentPalabrasBinding

class SubCategoriaFragment : Fragment() {


    private var _binding: FragmentPalabrasBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPalabrasBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        arguments?.let {
            val categoria = it.get("categoria") as Categorias

            val adaptercategoria =
                adapterSubCategorias(requireActivity(), categoria.sub_categoria) {
                    val bundle = Bundle()
                    bundle.putParcelable("palabra", it)
                    Navigation.findNavController(view).navigate(R.id.action_palabrasFragment_to_videoFragment,bundle)
                }

            binding.dRecycleView.addItemDecoration( DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
            binding.dRecycleView.adapter = adaptercategoria
            binding.dRecycleView.layoutManager = LinearLayoutManager(requireActivity())

        }
    }

}