package org.senac.gabrielkraetzer.boaviagem.ui.gasto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.databinding.FragmentGastoBinding
import java.sql.Date

class FragmentGasto : Fragment() {

    private val gastoView : GastoViewModel by navGraphViewModels(R.id.nav_gasto)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGastoBinding>(
            inflater,
            R.layout.fragment_gasto,
            container,
            false
        )

        binding.btNovoGasto.setOnClickListener{
            gastoView.selected.value.apply {
                this?.data = Date.valueOf(binding.edDataGasto?.text.toString())
                this?.descricao = binding.edDescricaoGasto?.text.toString()
                this?.tipo = "Alimentação"
                this?.local = binding.edLocalGasto?.text.toString()
            }
            gastoView.save(gastoView.selected.value!!)
        }

        return binding.root
    }
}