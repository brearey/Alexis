package ru.oktemsec.sashapopov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PainZoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pain_zone)

        findViewById<Button>(R.id.pain_zone).setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}