package ru.oktemsec.sashapopov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MeningitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meningit)

        val gotomapButton: Button = findViewById<Button>(R.id.gotomap)
        val backButton: Button = findViewById<Button>(R.id.backButton)

        gotomapButton.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }

        backButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}