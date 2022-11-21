package com.example.lsm

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lsm.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.io.File.separator


class MainActivity : AppCompatActivity()   {
    //Binding para la actividad principal
    lateinit var binding: ActivityMainBinding
    val bind get() = binding!!
    //Control de navegacion entre fragments
    lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        //Hacer que los datos sean persistentes. Si no hay conexion a internet
        //los datos que se mandan a la base de datos se guardan localmente hasta
        //que haya una conexion a internet
        Firebase.database.setPersistenceEnabled(true)

        super.onCreate(savedInstanceState)

        //Inflar la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click listener para el boton del menu
        binding.topAppBar.setNavigationOnClickListener(){
            //Abrir el drawer cuando se pica el boton del menu
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }



        //Obtener los datos guardados en el dispositivo
        val sharedPref  = this.getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            remove("categoriaActual")
            apply()
        }


        if(!sharedPref.contains("categoriaActual")) {
            with(sharedPref.edit()) {
                putInt("categoriaActual", 0)
                apply()
            }
        }

        //Ver si hay un usuario ya en login para ver si las evaluaciones estan disponibles o no
        if(sharedPref.contains("username") && sharedPref.contains("password") ){
            binding.drawer.menu.findItem(R.id.evaluacionMenuItem).isVisible = true;
            binding.drawer.menu.findItem(R.id.SignOut).isVisible = true;
            binding.topAppBar.menu.findItem(R.id.loginMenuItem).setIcon(R.drawable.ic_baseline_account_circle_24)
        } else {
            binding.drawer.menu.findItem(R.id.evaluacionMenuItem).isVisible = false;
            binding.drawer.menu.findItem(R.id.SignOut).isVisible = false;
            binding.topAppBar.menu.findItem(R.id.loginMenuItem).setIcon(R.drawable.login)


        }

        //En menu el icono para hacer un login
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.loginMenuItem -> {
                    if(sharedPref.contains("username") && sharedPref.contains("password") ) {
                        navController.navigate(R.id.profileFragment)
                    } else {
                        //Navegar a la pagina de login
                        navController.navigate(R.id.loginFragment)
                    }
                    true
                }
                else -> false
            }
        }


        //Obtener el host de fragments
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerMainActivity) as NavHostFragment
        //Crear el controll en base al host
        navController = navHostFragment.navController

        //Navegar mediante las differentes opciones del drawer
        binding.drawer.setNavigationItemSelectedListener() {
            when (it.itemId) {
                //En cada uno navegar al fragmento seleccionado y cerrar el drawer
                R.id.dicionarioMenuItem -> {
                    navController.navigate(R.id.dictionaryFragment)
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    true
                }

                R.id.SignOut -> {
                    //Si se quiere salir de cuenta quitar de sharedpreferences usuario y contraseña
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    val sharedPref  = this.getPreferences(Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        remove("username")
                        remove("password")
                        apply()
                    }

                    //Deshabilitar la opcion de evaluacion y de sign out
                    navController.navigate(R.id.dictionaryFragment)
                    binding.drawer.menu.findItem(R.id.evaluacionMenuItem).isVisible = false;
                    binding.drawer.menu.findItem(R.id.SignOut).isVisible = false;
                    binding.topAppBar.menu.findItem(R.id.loginMenuItem).setIcon(R.drawable.login)


                    true
                }

                R.id.juegoMenuItem -> {
                    navController.navigate(R.id.juegoFragment)
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    true
                }
                R.id.evaluacionMenuItem -> {
                    navController.navigate(R.id.evaluacionFragment)
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    true
                }
                R.id.preferenciasMenuItem -> {
                    navController.navigate(R.id.preferencesFragment)
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    true
                }
                else -> false
            }
        }


    }


    //Create top bar menu when menu is created
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        //Inflar el menu principal
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mainmenu,menu)


        return true
    }


}