package org.senac.gabrielkraetzer.boaviagem.ui.viagem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.navGraphViewModels
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.databinding.FragmentViagemBinding
import java.sql.Date


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentViagem : Fragment() {

    private val viagemView : ViagemViewModel by navGraphViewModels(R.id.nav_consultaViagem)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentViagemBinding>(
            inflater,
            R.layout.fragment_viagem,
            container,
            false
        )

        binding.btNovaViagem.setOnClickListener {
            viagemView.selected.value.apply {
                this?.destino = binding.edDestinoViagem?.text.toString()
                this?.dataChegada = Date.valueOf(binding.dataChegadaViagem?.text.toString())
                this?.dataPartida = Date.valueOf(binding.dataPartidaViagem?.text.toString())
                this?.qtdePessoas = binding.edQtdPessoasViagem?.text.toString().toInt()
                this?.tipo = binding.grupoTipoViagem.id
            }

            viagemView.salvar(viagemView.selected.value!!)

            Navigation.findNavController(it).navigateUp()
        }
        return binding.root
    }

}