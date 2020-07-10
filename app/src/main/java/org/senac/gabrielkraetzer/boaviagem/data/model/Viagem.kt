package org.senac.gabrielkraetzer.boaviagem.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.time.LocalDate
import java.util.*

@Entity(tableName = "viagem")
data class Viagem(
    var destino : String?,
    var tipo : Int?,
    var dataChegada : Date?,
    var dataPartida : Date?,
    var qtdePessoas : Int?,
    var orcamento : Double?) {


    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}