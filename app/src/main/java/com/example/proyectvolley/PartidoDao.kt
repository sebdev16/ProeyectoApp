package com.example.proyectvolley


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PartidoDao {
    @Query("SELECT * FROM partidos ORDER BY fecha DESC")
    fun obtenerPartidos(): Flow<List<Partido>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPartido(partido: Partido)

    @Delete
    suspend fun eliminarPartido(partido: Partido)

}