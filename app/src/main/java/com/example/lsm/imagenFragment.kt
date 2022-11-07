package com.example.lsm

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.lsm.databinding.FragmentImagenBinding
import com.example.lsm.databinding.FragmentVideoBinding

class imagenFragment : Fragment() {


    private var _binding: FragmentImagenBinding? = null
    private val binding get()  = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImagenBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val palabra = it.get("palabra") as PalabrasRV
            binding.textView2.text = palabra.nombre
            val image_id = palabra.local_video_url
            val offlineUrl = Uri.parse("android.resource://${requireContext().packageName}/${image_id}")
            Glide.with(requireActivity().applicationContext).load(offlineUrl).into(binding.imageView2)

            val categoria = it.get("categoria") as Categorias
            val bundle = Bundle()
            bundle.putParcelable("categoria", categoria)
            activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_imagenFragment_to_palabrasFragment, bundle)
                }
            })
        }
    }

}