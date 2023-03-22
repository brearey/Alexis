package ru.oktemsec.sashapopov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PainZoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pain_zone)

        findViewById<Button>(R.id.pain_zone_head).setOnClickListener {
            // send ID of pain zone
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("painZone", "meningit")
            startActivity(intent)
        }

        findViewById<Button>(R.id.pain_zone_stomach).setOnClickListener {
            // send ID of pain zone
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("painZone", "gastrit")
            startActivity(intent)
        }
    }
}