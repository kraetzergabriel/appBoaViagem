package org.senac.gabrielkraetzer.boaviagem.data

import android.provider.ContactsContract
import androidx.room.Database
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto
import org.senac.gabrielkraetzer.boaviagem.data.model.Viagem

@Database(entities = arrayOf(
        Gasto::class,
        Viagem::class), version = 1, exportSchema = false)
abstract class AppDataBase {


    companion object {
        @Volatile
    }
}