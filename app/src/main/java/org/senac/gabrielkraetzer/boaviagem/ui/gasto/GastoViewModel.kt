package org.senac.gabrielkraetzer.boaviagem.ui.gasto

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.senac.gabrielkraetzer.boaviagem.data.AppDataBase
import org.senac.gabrielkraetzer.boaviagem.data.dao.GastoDao
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto

class GastoViewModel(application: Application, val id : Int) : AndroidViewModel(application){

    private val gastoDao : GastoDao
    var gastos : LiveData<List<Gasto>>

    val selected = MutableLiveData<Gasto>()

    init {
        gastoDao = AppDataBase.getDataBase(application).gastoDao()
        gastos = gastoDao.getGastoByIdViagem(id)
    }

    fun selectAll(id : Int){
        gastos = gastoDao.getGastoByIdViagem(id)
    }

    fun select(gasto: Gasto){
        this.selected.value = gasto
    }

    fun save(gasto: Gasto) {
        viewModelScope.launch {
            if (gasto.id == 0) {
                gastoDao.insert(gasto)
            } else {
                gastoDao.update(gasto)
            }
        }
    }

    fun delete(gasto: Gasto) {
        viewModelScope.launch (Dispatchers.IO) {
            gastoDao.delete(gasto)
        }
    }
}