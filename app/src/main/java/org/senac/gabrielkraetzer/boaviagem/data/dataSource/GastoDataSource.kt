package org.senac.gabrielkraetzer.boaviagem.data.dataSource

import androidx.lifecycle.LiveData
import androidx.room.*
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto

@Dao
interface GastoDataSource {

    @Query("select * from gasto order by id asc")
    fun getGasto() : LiveData<List<Gasto>>

    @Query("select * from gasto where id = :id")
    fun getGastoById(id : Int) : LiveData<Gasto>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gasto : Gasto)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(gasto: Gasto)
}