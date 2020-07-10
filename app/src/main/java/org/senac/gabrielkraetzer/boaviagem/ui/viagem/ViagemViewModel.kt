package org.senac.gabrielkraetzer.boaviagem.ui.viagem

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.senac.gabrielkraetzer.boaviagem.data.AppDataBase
import org.senac.gabrielkraetzer.boaviagem.data.dao.ViagemDao
import org.senac.gabrielkraetzer.boaviagem.data.model.Viagem

class ViagemViewModel(application: Application) : AndroidViewModel(application) {

    private val viagemDao : ViagemDao = AppDataBase.getDataBase(application).viagemDao()
    val viagens : LiveData<List<Viagem>>

    val selected = MutableLiveData<Viagem>()

    init {
        viagens = viagemDao.getViagem()
    }

    fun select(viagem: Viagem) {
        this.selected.value = viagem
    }

    fun salvar(viagem: Viagem) {
        viewModelScope.launch {
            if (viagem.id == 0) {
                viagemDao.insert(viagem)
            } else {
                viagemDao.update(viagem)
            }
        }
    }

    fun delete(viagem: Viagem) {
        viewModelScope.launch( Dispatchers.IO){
            viagemDao.delete(viagem)
        }
    }
}