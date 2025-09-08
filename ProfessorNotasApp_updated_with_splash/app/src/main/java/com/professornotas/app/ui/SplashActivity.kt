package com.professornotas.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.professornotas.app.R
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    private val splashTime: Long = 2000 // 2 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Usando coroutine para delay elegante
        CoroutineScope(Dispatchers.Main).launch {
            delay(splashTime)
            startActivity(Intent(this@SplashActivity, DashboardActivity::class.java))
            finish()
        }
    }
}
