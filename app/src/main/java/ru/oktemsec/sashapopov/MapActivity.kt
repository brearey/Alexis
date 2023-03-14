package ru.oktemsec.sashapopov

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MapActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val webview: WebView = findViewById(R.id.webview)
        webview.loadUrl("http://xn--h1aafpog.xn--90ahbflhjgobv0ae.xn--p1ai/alexis/")
        webview.settings.javaScriptEnabled = true
    }
}