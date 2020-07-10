package org.senac.gabrielkraetzer.boaviagem.ui.adapter

import android.os.Build
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.data.model.Viagem
import java.text.DateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class ViagemAdpater() : RecyclerView.Adapter<ViagemAdpater.ViagemViewHolder>() {

    var viagens = emptyList<Viagem>()

    var onItemClick: ((Viagem) -> Unit)? = null

    var onExcluir: ((Viagem) -> Boolean)? = null

    inner class ViagemViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        var itemConsultaViagemDesc1 = itemView.findViewById<TextView>(R.id.itemConsultaViagemDesc1)
        var itemConsultaViagemDesc2 = itemView.findViewById<TextView>(R.id.itemConsultaViagemDesc2)
        var itemConsultaViagemDesc3 = itemView.findViewById<TextView>(R.id.itemConsultaViagemDesc3)

        init {
            itemView.setOnClickListener(){
                onItemClick?.invoke(viagens.get(adapterPosition))
            }
            itemView.setOnCreateContextMenuListener(this)
        }

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            menu?.setHeaderTitle("Opções")
            val excluir = menu?.add("Excluir")

            excluir?.setOnMenuItemClickListener {
                onExcluir?.invoke(viagens.get(adapterPosition)) ?: false
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViagemViewHolder {
        val itemView = LayoutInflater.from(parent.context).
            inflate(R.layout.item_consulta_viagem, parent, false)

        return ViagemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return viagens.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViagemViewHolder, position: Int) {
        var viagem = viagens.get(position)

        val formatacao = DateFormat.getDateInstance()

        holder.itemConsultaViagemDesc1.text = viagem.destino
        holder.itemConsultaViagemDesc2.text = "${formatacao.format(viagem.dataChegada)} a ${formatacao.format(viagem.dataPartida)}"
        holder.itemConsultaViagemDesc3.text = "Gasto Total ${String.format("%.2f",viagem.orcamento)}"
    }

    internal fun setViagens(viagens : List<Viagem>){
        this.viagens = viagens
        notifyDataSetChanged()
    }
}