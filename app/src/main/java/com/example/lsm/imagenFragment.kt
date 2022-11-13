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

//Fragmento para enseñar las imagenes del diccionario
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
        //Agarrar lo que viene en el bundle
        arguments?.let {
            //agarrar la palabra y convertirlo a objeto de palabra
            val palabra = it.get("palabra") as PalabrasRV
            //Cambiar el titulo por el nombre de la palabra
            binding.textView2.text = palabra.nombre
            //Sacar el id en el folder raw de la imagen
            val image_id = palabra.local_video_url
            //Convertir el id a URI para sacar la imagen
            val offlineUrl = Uri.parse("android.resource://${requireContext().packageName}/${image_id}")
            //Con glide poner la imagen en el imageView
            Glide.with(requireActivity().applicationContext).load(offlineUrl).into(binding.imageView2)

            //Tambien sacar de que categoria viene la palabra
            val categoria = it.get("categoria") as Categorias
            //Crear un bundle con la categoria
            val bundle = Bundle()
            bundle.putParcelable("categoria", categoria)
            //Cuando se presiona el boton para regresar en el sistema de android
            activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //Navegar a la vista de categoria con la categoria donde proviene la palabra actual
                    Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_imagenFragment_to_palabrasFragment, bundle)
                }
            })
        }
    }

}