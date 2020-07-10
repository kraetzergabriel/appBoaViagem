package org.senac.gabrielkraetzer.boaviagem.ui.gasto

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto
import org.senac.gabrielkraetzer.boaviagem.ui.adapter.GastoAdapter

class ConsultaGasto : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val id = intent.getStringExtra("IDVIAGEM")
        val viewModel : GastoViewModel by viewModels()

        findViewById<FloatingActionButton>(R.id.floatingButtonNovoGasto).setOnClickListener{
            viewModel.select(Gasto("",0.0, null, "","",id.toInt()))
            Navigation.findNavController(it).navigate(R.id.action_activityGasto_to_fragment_gasto)
        }
        recyclerView.adapter = GastoAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}