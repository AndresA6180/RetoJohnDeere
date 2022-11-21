package com.example.lsm

import android.R
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.lsm.databinding.FragmentProfileBinding
import com.google.firebase.database.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class profileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get()  = _binding!!
    lateinit var databaseUsuario : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseUsuario = FirebaseDatabase.getInstance().getReference("Usuarios")

        val sharedPref  = requireActivity().getPreferences(Context.MODE_PRIVATE)
        var usuario = sharedPref.getString("username", " ")!!

        var usuarioListaDeCategoriasCompletas : List<String> = emptyList()

        databaseUsuario.ref.orderByChild("usuario").equalTo(usuario).addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        if(dataSnapshot.child("listaCompletadas").exists()){
                            usuarioListaDeCategoriasCompletas = dataSnapshot.child("listaCompletadas").getValue() as List<String>

                            binding.progressBar.max = categoriasList.size - 1

                            binding.progressBar.progress = usuarioListaDeCategoriasCompletas.size - 1

                            val arrayAdapter: ArrayAdapter<*>

                            arrayAdapter = ArrayAdapter(requireActivity(), R.layout.simple_list_item_1, usuarioListaDeCategoriasCompletas)
                            binding.listView.adapter = arrayAdapter

                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.i("DbTest", "failed")
            }
        })



        //Si el usuario escoge regresar al fragmento pasado
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Navegar a lo que viene siendo el diccionario
                    Navigation.findNavController(view)
                        .navigate(com.example.lsm.R.id.dictionaryFragment)
                }
            })

    }
}