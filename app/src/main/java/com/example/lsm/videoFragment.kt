package com.example.lsm

import android.R.attr.path
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.lsm.databinding.FragmentVideoBinding
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.SlideDistanceProvider


class videoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    private val binding get()  = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enterTransition = MaterialFadeThrough().apply {
            duration = 500L
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Crear el control de media
        val mediaController = MediaController(context)
        //Poner el videoView a ese control
        mediaController.setAnchorView(binding.videoViewPalabra)

        //Recibir el bundle que se mando
        arguments?.let {
            //Cambiar la palabra a su objeto
            val palabra = it.get("palabra") as PalabrasRV

            //Sacar el id del video
            val video_id = palabra.local_video_url

            //Guardar la categoria de donde viene en un bundle por si se quiere regresar el usuario
            val categoria = it.get("categoria") as Categorias
            val bundle = Bundle()
            bundle.putParcelable("categoria", categoria)

            //Si el usuario se quiere regresar
            activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if(categoria.nombre != "buscador") {
                        //Regresar del fragmento de video al fragmento de palabras con la categoria en el bundle
                        Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_videoFragment_to_palabrasFragment, bundle)
                    } else {
                        Navigation.findNavController(view).navigate(R.id.action_videoFragment_to_buscadorFragment)
                    }

                }
            })

            //Si el video no es nulo
            if (video_id != null) {
                //Construir el URI
                val offlineUrl = Uri.parse("android.resource://${requireContext().packageName}/${video_id}")


                //Set del titulo y del video en el fragmento
                binding.tituloVideo.text = palabra.nombre
                binding.videoViewPalabra.setMediaController(mediaController)
                binding.videoViewPalabra.setVideoURI(offlineUrl)
                //Empezar el video
                binding.videoViewPalabra.start()

            } else {
                //Si esta vacio entonces decir que el video no esta disponible
                binding.videoViewPalabra.isVisible = false

                Toast.makeText(context, "VIDEO NO DISPONIBLE", Toast.LENGTH_SHORT).show()

            }

            //Si se selecciona el boton entonces se reproduce el video otra vez
            binding.button4.setOnClickListener(){
                binding.videoViewPalabra.start()
            }

        }
    }
}