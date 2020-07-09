package org.senac.gabrielkraetzer.boaviagem.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gasto")
data class Gasto(
    val tipo : String?,
    val orcamento : Double?,
    val valor : Double?,
    val data : Date?,
    val descricao : String?,
    val local : String?){

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0;
}