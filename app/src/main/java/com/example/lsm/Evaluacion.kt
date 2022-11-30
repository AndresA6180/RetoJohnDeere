package com.example.lsm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide
import com.example.lsm.databinding.ActivityMainBinding
import com.example.lsm.databinding.FragmentEvaluacionBinding


class Evaluacion : Fragment() {
    private var _binding: FragmentEvaluacionBinding? = null
    private val binding get()  = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEvaluacionBinding.inflate(inflater,container,false)
        val bundle = Bundle()
        bundle.putBoolean("boolean",true)
        bundle.putInt("categoria", 0)
        binding.evaluacionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.preguntasFragment, bundle))

        // Inflate the layout for this fragment
        return binding.root
    }

}