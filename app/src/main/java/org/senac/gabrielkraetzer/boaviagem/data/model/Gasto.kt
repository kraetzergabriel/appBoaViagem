package org.senac.gabrielkraetzer.boaviagem.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "gasto")
data class Gasto(
    var tipo : String?,
    val valor : Double?,
    var data : Date?,
    var descricao : String?,
    var local : String?,
    val idViagem: Int){

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0;
}