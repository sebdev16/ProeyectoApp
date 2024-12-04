package com.example.proyectvolley

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ParidoViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).partidoDao()
    val partidos: LiveData<List<Partido>> = dao.obtenerPartidos().asLiveData()

    fun agregarPartido(partido: Partido) = viewModelScope.launch {
        dao.insertarPartido(partido)
    }

    fun eliminarPartido(partido: Partido) = viewModelScope.launch {
        dao.eliminarPartido(partido)
    }

}