package org.senac.gabrielkraetzer.boaviagem.ui.adapter

import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.senac.gabrielkraetzer.boaviagem.R
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto

class GastoAdapter() : RecyclerView.Adapter<GastoAdapter.GastoViewHolder>() {

    var gastos = emptyList<Gasto>()

    var onExcluir: ((Gasto) -> Boolean)? = null

    inner class GastoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {
        var itemConsultaGastoDesc1 = itemView.findViewById<TextView>(R.id.itemConsultaGastoDesc1)
        var itemConsultaGastoDesc2 = itemView.findViewById<TextView>(R.id.itemConsultaGastoDesc2)

        init {
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
                onExcluir?.invoke(gastos.get(adapterPosition)) ?: false
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastoViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_consulta_gasto, parent, false)

        return GastoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return this.gastos.size
    }

    override fun onBindViewHolder(holder: GastoViewHolder, position: Int) {
        var gasto = this.gastos.get(position)

        holder.itemConsultaGastoDesc1.text = gasto.descricao;
        holder.itemConsultaGastoDesc2.text = String.format("%.2f", gasto.valor)
    }

    internal fun setGastos(gastos : List<Gasto>){
        this.gastos = gastos
        notifyDataSetChanged()
    }
}