package org.senac.gabrielkraetzer.boaviagem

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.senac.gabrielkraetzer.boaviagem.fragments.FragmentGasto
import org.senac.gabrielkraetzer.boaviagem.fragments.FragmentViagem

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        supportFragmentManager.
            beginTransaction().
            add(
                R.id.fragmentGasto,
                FragmentGasto()
            ).commit()

        findViewById<BottomNavigationView>(R.id.navigation_menu).setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fragmentGasto -> createFragment(FragmentGasto())
                R.id.fragmentViagem -> createFragment(
                    FragmentViagem()
                )
                else -> false
            } as Boolean
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