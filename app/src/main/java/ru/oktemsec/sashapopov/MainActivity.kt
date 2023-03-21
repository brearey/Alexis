package ru.oktemsec.sashapopov

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val healthButton = findViewById<ImageButton>(R.id.health_button)
        val sosButton = findViewById<ImageButton>(R.id.sos_button)

        healthButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, PainZoneActivity::class.java))
        }

        sosButton.setOnClickListener {
            call()
        }

    }

    private fun call() {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "103")
        startActivity(dialIntent)
    }
}