package com.example.lsm

import android.R.attr.left
import android.R.attr.right
import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.lsm.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity()   {
    //Binding para la actividad principal
    lateinit var binding: ActivityMainBinding
    val bind get() = binding!!
    //Control de navegacion entre fragments
    lateinit var  navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {

        val alarmManager = this.getSystemService(ALARM_SERVICE) as AlarmManager
        val alarmPendingIntent by lazy {
            val intent = Intent(this, AlarmReceiver::class.java)
            PendingIntent.getBroadcast(this, 0, intent, 0)
        }
        val HOUR_TO_SHOW_PUSH = 8

        schedulePushNotifications(alarmManager,alarmPendingIntent,HOUR_TO_SHOW_PUSH)

        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


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


        if(!sharedPref.contains("categoriaActual")) {
            with(sharedPref.edit()) {
                putInt("categoriaActual", 0)
                apply()
            }
        }

        //Ver si hay un usuario ya en login para ver si las evaluaciones estan disponibles o no
        if(sharedPref.contains("username") && sharedPref.contains("password") ){
            if(sharedPref.getBoolean("administrador", false)){
                binding.drawer.menu.findItem(R.id.SignOut).isVisible = true;
                binding.drawer.menu.findItem(R.id.evaluacionMenuItem).isVisible = false;
                binding.topAppBar.menu.findItem(R.id.loginMenuItem).setIcon(R.drawable.data)

            } else {
                binding.drawer.menu.findItem(R.id.evaluacionMenuItem).isVisible = true;
                binding.drawer.menu.findItem(R.id.SignOut).isVisible = true;
                binding.topAppBar.menu.findItem(R.id.loginMenuItem).setIcon(R.drawable.ic_baseline_account_circle_24)
                binding.drawerLayout.isEnabled = true
            }
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
                        if(sharedPref.getBoolean("administrador", false)){
                            navController.navigate(R.id.reporteFragment2)
                        } else {
                            navController.navigate(R.id.profileFragment)
                        }
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
                    true
                }

                R.id.SignOut -> {
                    //Si se quiere salir de cuenta quitar de sharedpreferences usuario y contraseña
                    binding.drawerLayout.closeDrawer(Gravity.LEFT)
                    val sharedPref  = this.getPreferences(Context.MODE_PRIVATE)
                    with(sharedPref.edit()) {
                        remove("username")
                        remove("password")
                        remove("administrador")
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

                R.id.buscadorMenuItem -> {
                    navController.navigate(R.id.buscadorFragment)
                    true
                }

                else -> false
            }
        }


    }

    fun schedulePushNotifications(
        alarmManager: AlarmManager,
        alarmPendingIntent: PendingIntent,
        HOUR_TO_SHOW_PUSH: Int
    ) {
        val calendar = GregorianCalendar.getInstance().apply {
            if (get(Calendar.HOUR_OF_DAY) >= HOUR_TO_SHOW_PUSH) {
                add(Calendar.DAY_OF_MONTH, 1)
            }
            set(Calendar.HOUR_OF_DAY, HOUR_TO_SHOW_PUSH)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        val calendarInterval = GregorianCalendar.getInstance().apply {
            set(Calendar.HOUR, 96)
        }

        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            calendarInterval.timeInMillis,
            alarmPendingIntent
        )
    }



    //Create top bar menu when menu is created
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        //Inflar el menu principal
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.mainmenu,menu)


        return true
    }


}