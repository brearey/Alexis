package ru.oktemsec.sashapopov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val healthButton = findViewById<ImageButton>(R.id.health_button)

        healthButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, PainZoneActivity::class.java))
        }

    }
}