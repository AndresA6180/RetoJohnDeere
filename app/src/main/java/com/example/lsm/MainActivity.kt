package com.example.lsm

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lsm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()   {
    //Binding para la actividad principal
    lateinit var binding: ActivityMainBinding
    //Control de navegacion entre fragments
    lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click listener para el boton del menu
        binding.topAppBar.setNavigationOnClickListener(){
            //Abrir el drawer cuando se pica el boton del menu
            binding.drawerLayout.openDrawer(Gravity.LEFT)

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
                R.id.loginMenuItem -> {
                    navController.navigate(R.id.loginFragment)
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
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