package com.example.lsm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lsm.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity()   {
    //Binding to get all of the ids
    lateinit var binding: ActivityMainBinding
    //Navigation controller
    lateinit var  navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click listener for menu botton on top bar
        binding.topAppBar.setOnClickListener(){
            binding.drawerLayout.openDrawer(Gravity.LEFT)

        }

        //Get navigation host fragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerMainActivity) as NavHostFragment
        //Create nav controller
        navController = navHostFragment.navController

        //Navigate through the different menu options
        binding.drawer.setNavigationItemSelectedListener() {
            when (it.itemId) {
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
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mainmenu,menu)
        return true
    }


}