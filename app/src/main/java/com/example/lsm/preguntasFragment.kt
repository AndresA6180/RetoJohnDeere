package com.example.lsm

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Vibrator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.lsm.databinding.FragmentPreguntasBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.database.*


class preguntasFragment : Fragment() {

    private var _binding: FragmentPreguntasBinding? = null
    private val binding get() = _binding!!
    lateinit var databaseCategorias : DatabaseReference
    lateinit var databaseUsuario : DatabaseReference
    private var palabraCorrecta : PalabrasRV = categoriasList[0].sub_categoria[0];
    private var listaDePreguntas : List<PalabrasRV> = emptyList();
    private var counterTotal  : Int = 0;
    private var practicaOEvaluacion : Boolean = false;
    private var categoriaActual : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPreguntasBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriasList.sortBy { it.nombre }

        arguments?.let {
            //Obtener la categoria seleccionada
            practicaOEvaluacion = it.getBoolean("boolean")
            categoriaActual = it.getInt("categoria")
        }

        if(practicaOEvaluacion == true){
            databaseCategorias = FirebaseDatabase.getInstance().getReference("Categorias")
            databaseUsuario = FirebaseDatabase.getInstance().getReference("Usuarios")

            val sharedPref  = requireActivity().getPreferences(Context.MODE_PRIVATE)
            categoriaActual = sharedPref.getInt("categoriaActual", 0)!!
        }



        var listaDePalabras : List<PalabrasRV> = categoriasList[categoriaActual].sub_categoria

        var counterDeCorrectas = 0;
        counterTotal = 0;
        listaDePreguntas = emptyList();

        escogerPalabras(listaDePalabras, counterTotal, counterDeCorrectas)


        binding.opcion1.setOnClickListener(){
            if(binding.opcion1.text == palabraCorrecta.nombre){
                counterDeCorrectas += 1;
                binding.opcion1.setBackgroundColor(resources.getColor(R.color.Verde))
            } else {
                binding.opcion1.setBackgroundColor(resources.getColor(R.color.Rojo))
                if(binding.opcion3.text == palabraCorrecta.nombre){
                    binding.opcion3.setBackgroundColor(resources.getColor(R.color.Verde))
                } else {
                    binding.opcion2.setBackgroundColor(resources.getColor(R.color.Verde))
                }
            }
            siguientePregunta(counterDeCorrectas,listaDePalabras)
        }

        binding.opcion2.setOnClickListener(){
            if(binding.opcion2.text == palabraCorrecta.nombre){
                counterDeCorrectas += 1;
                binding.opcion2.setBackgroundColor(resources.getColor(R.color.Verde))
            } else {
                binding.opcion2.setBackgroundColor(resources.getColor(R.color.Rojo))
                if(binding.opcion3.text == palabraCorrecta.nombre){
                    binding.opcion3.setBackgroundColor(resources.getColor(R.color.Verde))
                } else {
                    binding.opcion1.setBackgroundColor(resources.getColor(R.color.Verde))
                }
            }
            siguientePregunta(counterDeCorrectas,listaDePalabras)
        }

        binding.opcion3.setOnClickListener(){
            if(binding.opcion3.text == palabraCorrecta.nombre){
                counterDeCorrectas += 1;
                binding.opcion3.setBackgroundColor(resources.getColor(R.color.Verde))
            } else {
                binding.opcion3.setBackgroundColor(resources.getColor(R.color.Rojo))
                if(binding.opcion2.text == palabraCorrecta.nombre){
                    binding.opcion2.setBackgroundColor(resources.getColor(R.color.Verde))
                } else {
                    binding.opcion1.setBackgroundColor(resources.getColor(R.color.Verde))
                }
            }
            siguientePregunta(counterDeCorrectas,listaDePalabras)
        }
    }

    fun escogerPalabras(listaDePalabras : List<PalabrasRV>, counterTotal : Int,counterDeCorrectas : Int){

        binding.progressBar2.progress = counterTotal
        binding.textView5.text = counterTotal.toString() + "/5";
        if(counterTotal == 5){
            if(((counterDeCorrectas/counterTotal)*100) > 70){
                if(practicaOEvaluacion == true) {
                    var usuario: String = "";
                    var categoriaActual: Int
                    var usuariosConCategoriaCompletada: List<String> = emptyList()
                    var ps: String = ""


                    //Obtener usuario, categoria actual y password
                    val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
                    usuario = sharedPref.getString("username", " ")!!
                    categoriaActual = sharedPref.getInt("categoriaActual", 0)!!
                    ps = sharedPref.getString("password", " ")!!


                    databaseCategorias.ref.orderByChild("categoria")
                        .equalTo(categoriasList[categoriaActual].nombre)
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    for (dataSnapshot in snapshot.children) {
                                        if (dataSnapshot.child("usuarios").exists()) {
                                            usuariosConCategoriaCompletada =
                                                dataSnapshot.child("usuarios").value as List<String>
                                        }
                                    }
                                    usuariosConCategoriaCompletada =
                                        usuariosConCategoriaCompletada.plus(usuario)

                                    var nuevaLista = CategoriasCompletas(
                                        categoriasList[categoriaActual].nombre,
                                        usuariosConCategoriaCompletada
                                    )

                                    databaseCategorias.child(categoriasList[categoriaActual].nombre)
                                        .setValue(nuevaLista)
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.i("DbTest", "failed")
                            }
                        })


                    var usuarioListaDeCategoriasCompletas: List<String> = emptyList()
                    databaseUsuario.ref.orderByChild("usuario").equalTo(usuario)
                        .addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                if (snapshot.exists()) {
                                    for (dataSnapshot in snapshot.children) {
                                        if (dataSnapshot.child("listaCompletadas").exists()) {
                                            usuarioListaDeCategoriasCompletas =
                                                dataSnapshot.child("listaCompletadas")
                                                    .getValue() as List<String>
                                        }
                                    }

                                    var nuevaListaCategoriasUsuario =
                                        usuarioListaDeCategoriasCompletas.plus(categoriasList[categoriaActual].nombre)
                                    var usuarioActualizado =
                                        Usuario(usuario, ps, nuevaListaCategoriasUsuario)
                                    databaseUsuario.child(usuario).setValue(usuarioActualizado)

                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                Log.i("DbTest", "failed")
                            }
                        })


                    var nuevaCategoria = categoriaActual + 1

                    with(sharedPref.edit()) {
                        putInt("categoriaActual", nuevaCategoria)
                        apply()
                    }
                }
                MaterialAlertDialogBuilder(requireActivity()).setTitle("Resultados").setMessage("Ha aprobado la evaluacion").setNegativeButton("Continuar"){
                        dialog, which ->
                    findNavController().navigate(R.id.evaluacionFragment)
                }.show()

                return

            } else {
                MaterialAlertDialogBuilder(requireActivity()).setTitle("Resultados").setMessage("No aprobado la evaluacion").setNegativeButton("Continuar"){
                        dialog, which ->
                    findNavController().navigate(R.id.evaluacionFragment)
                }.show()
                return
            }
        }

        enableDisable(true)

        binding.opcion1.setBackgroundColor(Color.TRANSPARENT)
        binding.opcion2.setBackgroundColor(Color.TRANSPARENT)
        binding.opcion3.setBackgroundColor(Color.TRANSPARENT)

        var random1 = (0..(listaDePalabras.size-1)).random()
        var random2 = (0..(listaDePalabras.size-1)).random();

        while(random1 == random2){
            random2 = (0..(listaDePalabras.size-1)).random()
        }

        var random3 = (0..(listaDePalabras.size-1)).random();

        while(random1 == random3 || random2 == random3){
            random3 = (0..(listaDePalabras.size-1)).random();
        }

        var palabraPrimera : PalabrasRV= listaDePalabras[random1];
        var palabraSegunda : PalabrasRV = listaDePalabras[random2];
        var palabraTercera : PalabrasRV = listaDePalabras[random3];

        var listaOpciones = listOf<PalabrasRV>(palabraPrimera, palabraSegunda, palabraTercera)

        palabraCorrecta = listaOpciones[(0..2).random()]

        for(palabra in listaDePreguntas){
            if(palabra.nombre == palabraCorrecta.nombre){
                escogerPalabras(listaDePalabras, counterTotal,counterDeCorrectas)
                return
            }
        }

        listaDePreguntas = listaDePreguntas.plus(palabraCorrecta)

        //Crear el control de media
        val mediaController = MediaController(context)
        //Poner el videoView a ese control
        mediaController.setAnchorView(binding.videoView)

        //Sacar el id del video
        val video_id = palabraCorrecta.local_video_url
        val offlineUrl = Uri.parse("android.resource://${requireContext().packageName}/${video_id}")
        var name  = resources.getResourceName(palabraCorrecta.local_video_url.toString().toInt())
        if(name.contains("web")) {
            binding.videoView.isVisible = true;
            binding.imageView3.isVisible = false;
            binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(offlineUrl)
            binding.videoView.start()
        } else {
            binding.videoView.isVisible = false;
            binding.imageView3.isVisible = true;
            Glide.with(requireActivity().applicationContext).load(offlineUrl).into(binding.imageView3)
        }
        binding.opcion1.text = palabraPrimera.nombre;
        binding.opcion2.text = palabraSegunda.nombre;
        binding.opcion3.text = palabraTercera.nombre;
    }

    fun enableDisable(status : Boolean){
        binding.opcion1.isEnabled = status;
        binding.opcion2.isEnabled = status;
        binding.opcion3.isEnabled = status;
    }

    fun siguientePregunta(counterDeCorrectas: Int, listaDePalabras: List<PalabrasRV>){
        enableDisable(false)
        Handler().postDelayed({
            counterTotal += 1
            escogerPalabras(listaDePalabras,counterTotal,counterDeCorrectas)
        }, 2000)
    }
}