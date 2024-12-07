package com.example.proyectvolley

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectvolley.ui.theme.ProyectVolleyTheme
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectVolleyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}





@Composable
fun MainScreen(viewModel: ParidoViewModel = viewModel()) {
    val partidos by viewModel.partidos.observeAsState(emptyList())
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Navegar a pantalla de agregar partido */ }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar Partido")
            }
        },
        content = { padding ->
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(partidos) { partido ->
                    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(text = "${partido.equipoA} vs ${partido.equipoB}", style = MaterialTheme.typography.titleMedium)
                            Text(text = "Marcador: ${partido.marcadorA} - ${partido.marcadorB}", style = MaterialTheme.typography.bodyMedium)
                            Text(text = "Fecha: ${dateFormat.format(Date(partido.fecha))}", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectVolleyTheme {
        Greeting("Android")
    }
}