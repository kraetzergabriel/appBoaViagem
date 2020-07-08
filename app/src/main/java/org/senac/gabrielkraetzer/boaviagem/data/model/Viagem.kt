package org.senac.gabrielkraetzer.boaviagem.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "viagem")
data class Viagem(
    val destino : String,
    val tipo : Int,
    val dataChegada : Date,
    val dataPartida : Date,
    val qtdePessoas : Int) {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}