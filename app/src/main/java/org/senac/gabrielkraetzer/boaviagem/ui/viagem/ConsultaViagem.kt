package org.senac.gabrielkraetzer.boaviagem.ui.viagem

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.data.model.Viagem
import org.senac.gabrielkraetzer.boaviagem.databinding.ConsultaViagemBinding
import org.senac.gabrielkraetzer.boaviagem.ui.adapter.ViagemAdpater
import org.senac.gabrielkraetzer.boaviagem.ui.gasto.ConsultaGasto

class ConsultaViagem : Fragment() {

    private val consultaViagemViewModel : ViagemViewModel by viewModels()

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

            it.floatingButtonNovaViagem?.setOnClickListener{
                consultaViagemViewModel.select(Viagem("", 0, null, null, 0,0.0))

                Navigation.findNavController(it).navigate(R.id.action_consultaViagem_to_fragmentViagem)
            }

            adapter.onItemClick.let {
                it.apply {
                    val intent = Intent(context, ConsultaGasto::class.java).apply {
                        putExtra("IDVIAGEM", this@ConsultaViagem.id)
                    }
                    startActivity(intent)
                }
                true
            }
        }
    }
}