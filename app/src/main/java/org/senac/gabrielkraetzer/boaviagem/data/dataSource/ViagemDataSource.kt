package org.senac.gabrielkraetzer.boaviagem.data.dataSource

import androidx.lifecycle.LiveData
import androidx.room.*
import org.senac.gabrielkraetzer.boaviagem.data.model.Viagem

@Dao
interface ViagemDataSource {

    @Query("select * from viagem order by id asc")
    fun getViagem() : LiveData<List<Viagem>>

    @Query("select * from viagem where id = :id")
    fun getViagemById(id: Int) : LiveData<Viagem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(viagem: Viagem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg viagem: Viagem)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(viagem: Viagem)
}