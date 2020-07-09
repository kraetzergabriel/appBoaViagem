package org.senac.gabrielkraetzer.boaviagem.ui.viagem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.databinding.ConsultaViagemBinding
import org.senac.gabrielkraetzer.boaviagem.ui.adapter.ViagemAdpater

class ConsultaViagem : Fragment() {

    private val consultaViagemViewModel : ViagemViewModel by navGraphViewModels(R.id.nav_principal)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<ConsultaViagemBinding>(
            inflater,
            R.layout.consulta_viagem,
            container,
            false
        )

        bindListViagens(binding)
        binding.viagem = consultaViagemViewModel
        binding.setLifecycleOwner(this)

        return binding.root
    }

    private fun bindListViagens(binding: ConsultaViagemBinding?) {
        val adapter = ViagemAdpater()

        binding?.let {
            it.recyclerViewConsultaViagem?.adapter = adapter
            it.recyclerViewConsultaViagem?.layoutManager = LinearLayoutManager(context)

            consultaViagemViewModel.viagens.observe(this.viewLifecycleOwner, Observer { dados ->
                dados?.let {
                    adapter.setViagens(it)
                }
            })
        }
    }
}