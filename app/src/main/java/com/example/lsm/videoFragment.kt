package com.example.lsm

import android.R.attr.path
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
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


class videoFragment : Fragment() {

    private var _binding: FragmentVideoBinding? = null
    private val binding get()  = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        val mediaController = MediaController(context)
        mediaController.setAnchorView(binding.videoViewPalabra)

        arguments?.let {
            val palabra = it.get("palabra") as PalabrasRV

            val video_id = palabra.local_video_url

            val categoria = it.get("categoria") as Categorias
            val bundle = Bundle()
            bundle.putParcelable("categoria", categoria)

            activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Navigation.findNavController(view).navigate(com.example.lsm.R.id.action_videoFragment_to_palabrasFragment, bundle)
                }
            })

            if (video_id != null) {

                val offlineUrl = Uri.parse("android.resource://${requireContext().packageName}/${video_id}")


                binding.tituloVideo.text = palabra.nombre
                binding.videoViewPalabra.setMediaController(mediaController)
                binding.videoViewPalabra.setVideoURI(offlineUrl)
                binding.videoViewPalabra.start()

            } else {
                binding.videoViewPalabra.isVisible = false

                Toast.makeText(context, "VIDEO NO DISPONIBLE", Toast.LENGTH_SHORT).show()

            }

            binding.button4.setOnClickListener(){
                binding.videoViewPalabra.start()
            }

        }
    }
}