package org.senac.gabrielkraetzer.boaviagem

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.senac.gabrielkraetzer.boaviagem.ui.gasto.FragmentGasto
import org.senac.gabrielkraetzer.boaviagem.ui.viagem.ConsultaViagem
import org.senac.gabrielkraetzer.boaviagem.ui.viagem.FragmentViagem

class MainPage : AppCompatActivity() {

    private lateinit var navigationView: BottomNavigationView;

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.main_page)

        Log.i("testeCreate", "testeCreate")

        Toast.makeText(this,"Teste",Toast.LENGTH_LONG).show()
        supportFragmentManager.
            beginTransaction().
            add(
                R.id.frame_principal,
                ConsultaViagem()
            ).commit()

        navigationView = findViewById<BottomNavigationView>(R.id.navigation_menu)
        navigationView.setOnNavigationItemSelectedListener {
            Log.i("teste", "Teste")
            when (it.itemId) {
                R.id.nav_fragmentGasto -> createFragment(FragmentGasto())
                R.id.nav_fragmentViagem -> createFragment(FragmentViagem())
                R.id.nav_consultaViagem -> createFragment(ConsultaViagem())
//                R.id.nav_fragmentConfiguracao -> createFragment(FragmentConfiguracao())
                else -> false
            }
        }
    }

    private fun createFragment(fragment : Fragment) : Boolean {
        supportFragmentManager.
                beginTransaction().
                replace(R.id.frame_principal, fragment).
                setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out).
                addToBackStack(null).
                commit()
        return true
    }
}