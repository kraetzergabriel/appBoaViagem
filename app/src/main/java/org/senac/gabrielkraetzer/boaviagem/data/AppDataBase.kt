package org.senac.gabrielkraetzer.boaviagem.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.senac.gabrielkraetzer.boaviagem.data.dao.GastoDao
import org.senac.gabrielkraetzer.boaviagem.data.dao.ViagemDao
import org.senac.gabrielkraetzer.boaviagem.data.model.DateConverter
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto
import org.senac.gabrielkraetzer.boaviagem.data.model.Viagem


@Database(entities = arrayOf(
        Gasto::class,
        Viagem::class),
    version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun gastoDao() : GastoDao
    abstract fun viagemDao() : ViagemDao

    companion object {
        @Volatile
        private var INSTANCE:AppDataBase? = null

        fun getDataBase(context: Context) : AppDataBase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            } else {
                synchronized(this){
                    val instance  = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "database-name"
                    ).build()
                    INSTANCE = instance

                    return instance;
                }
            }
        }
    }
}