package com.example.proyectvolley

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "partidos")
data class Partido(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val equipoA: String,
    val equipoB: String,
    val marcadorA: Int,
    val marcadorB: Int,
    val fecha: Long // Guardar fecha como timestamp
)
