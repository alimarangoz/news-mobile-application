package com.alimarangoz.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.web_view)

        var url = intent.getStringExtra("href")

        webView.webViewClient = WebViewClient()
        if (url != null) {
            webView.loadUrl(url)
        }

    }
}