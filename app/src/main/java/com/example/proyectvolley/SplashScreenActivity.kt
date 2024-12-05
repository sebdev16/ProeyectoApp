package com.example.proyectvolley

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Usa la API de SplashScreen
        val splashScreen = installSplashScreen()

        // Puedes personalizar la duración del splash screen aquí si lo deseas
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()  // Cierra la actividad splash después de navegar
        }, 3000) // 3 segundos de duración
    }

}