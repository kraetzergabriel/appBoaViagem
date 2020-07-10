package org.senac.gabrielkraetzer.boaviagem.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.senac.gabrielkraetzer.boaviagem.data.model.Gasto

@Dao
interface GastoDao {

    @Query("select * from gasto order by id asc")
    fun getGasto() : LiveData<List<Gasto>>

    @Query("select * from gasto where idViagem = :idViagem")
    fun getGastoByIdViagem(idViagem : Int): LiveData<List<Gasto>>;

    @Query("select * from gasto where id = :id")
    fun getGastoById(id : Int) : LiveData<Gasto>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gasto : Gasto)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(gasto: Gasto)

    @Delete()
    suspend fun delete(gasto: Gasto)
}