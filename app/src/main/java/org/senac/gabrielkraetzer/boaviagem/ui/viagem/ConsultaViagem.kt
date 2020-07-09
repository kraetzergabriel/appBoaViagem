package org.senac.gabrielkraetzer.boaviagem.ui.viagem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.databinding.ConsultaViagemDataBinding
import org.senac.gabrielkraetzer.boaviagem.ui.adapter.ViagemAdpater

class ConsultaViagem : Fragment() {

    private val consultaViagemViewModel : ViagemViewModel by navGraphViewModels(R.id.nav_principal)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= DataBindingUtil.inflate<ConsultaViagemDataBinding>(
            inflater,
            R.layout.consulta_viagem,
            container,
            false
        )
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun bindListViagens(binding : ConsultaViagemDataBinding){
        val adapter = ViagemAdpater()

        binding?.let {

        }
    }
}