package com.example.lsm

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.lsm.databinding.FragmentLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.FirebaseError
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class login : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get()  = _binding!!
    lateinit var database : DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        //Obtener la tabla de la base de datos que se va a usar
        //Usar la tabla de usuarios
        database = FirebaseDatabase.getInstance().getReference("Usuarios")

        binding.loginButton.setOnClickListener() {
            //Obtener el usuario y contraseña de la persona
            var nombre = binding.userNameInputTextField.editText?.text.toString()
            var password = binding.passwordInputTextField.editText?.text.toString()



            //Buscar por el usuario en la base de datos por el nombre
            database.ref.orderByChild("usuario").equalTo(nombre).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        for (dataSnapshot in snapshot.children) {
                            //Obtener la password para el usuario
                            val ps = dataSnapshot.child("password").value

                            //Validar que el password ingresado y el del usuario sean los mismos
                            if(ps == password){
                                //Guardar el login del usuario
                                val sharedPref  = requireActivity().getPreferences(Context.MODE_PRIVATE)
                                with(sharedPref.edit()) {
                                    putString("username",nombre)
                                    putString("password",password)
                                    apply()
                                }
                                //Habilitar las evaluaciones y opcion para sign out
                                val mainActivity = requireActivity() as MainActivity
                                mainActivity.bind.drawer.menu.findItem(R.id.evaluacionMenuItem).isVisible = true;
                                mainActivity.bind.drawer.menu.findItem(R.id.SignOut).isVisible = true
                                mainActivity.bind.topAppBar.menu.findItem(R.id.loginMenuItem).setIcon(R.drawable.ic_baseline_account_circle_24)

                                //Mensaje que login fue completado
                                MaterialAlertDialogBuilder(requireActivity()).setTitle("Login").setMessage("Ha realizado el login con exito.").setNegativeButton("Ok"){
                                        dialog, which ->
                                    findNavController().navigate(R.id.profileFragment)
                                }.show()

                            } else {
                                //Si no es la misma contraseña
                                Toast.makeText(activity, "Contraseña o usuario erroneo", Toast.LENGTH_LONG).show()
                            }
                        }
                    } else {
                        //Si no existe el usuario
                        Toast.makeText(activity, "Contraseña o usuario erroneo", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.i("DbTest", "failed")
                }

            })




        }

        // Inflate the layout for this fragment
        return binding.root
    }

}