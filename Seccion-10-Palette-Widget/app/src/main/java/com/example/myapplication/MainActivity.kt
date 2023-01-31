package com.example.myapplication

import android.content.Context
import android.media.Rating
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)
        activityContext = this
        // WEBVIEW: Para activar las webview de otras paginas, hay que activar JS y habilitar en el Manifiest que tenga acceso a INTERNET
//        var webView = findViewById<WebView>(R.id.webView)
//        var webSettings: WebSettings = webView.settings
//        webSettings.javaScriptEnabled = true
//        webView.webViewClient = WebViewClient()
//        webView.loadUrl("http://www.jotajotavm.com")

        // VIDEO WEB
//        var vvWeb = findViewById<VideoView>(R.id.vvWeb)
//        var mcWeb = MediaController(this)
//        mcWeb.setAnchorView(vvWeb)
//        vvWeb.setVideoPath("https://jotajotavm.com/img/video.mp4")
//        vvWeb.setMediaController(mcWeb)

        // VIDEO LOCAL
//        var vvLocal = findViewById<VideoView>(R.id.vvLocal)
//        var mcLocal = MediaController(this)
//        mcLocal.setAnchorView(vvLocal)
//        var path = "android.resource://" + packageName + "/" + R.raw.video
//        vvLocal.setVideoURI(Uri.parse(path))
//        vvLocal.setMediaController(mcLocal)
        // vvLocal.start() => Automaticamente empieza a reproducir el video

        // CALENDAR VIEW
//        var cvEjemplo = findViewById<CalendarView>(R.id.cvEjemplo)
//        var tvFecha = findViewById<TextView>(R.id.tvFecha)
//        cvEjemplo.setOnDateChangeListener { cv, year, month, day ->
//            var date = "$day/${month+1}/$year"
//            tvFecha.text = "Fecha seleccionada: $date"
//        }
//
//        var calendar = Calendar.getInstance()
//        calendar.set(2026, 5, 8)
//        cvEjemplo.date = calendar.timeInMillis
//
//        var fecha = cvEjemplo.date
//        var d = cvEjemplo.firstDayOfWeek
//        cvEjemplo.firstDayOfWeek = (d+1)%7 // Para empezar por el lunes

        // PROGRESS BAR
        var pbDeterminado = findViewById<ProgressBar>(R.id.pbDeterminado)
        var pbSecundario = findViewById<ProgressBar>(R.id.pbSecundaria)
        pbDeterminado.max = 500
        pbDeterminado.progress = 0
        pbSecundario.progress = 0
        pbSecundario.secondaryProgress = 0
        pbSecundario.max = 1000

        // SEEK BAR
        var sbNormal = findViewById<SeekBar>(R.id.sbNormal)
        sbNormal.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    Toast.makeText(activityContext, "Tu lo cambiaste", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        GlobalScope.launch {
            // progressManager(pbDeterminado)
            // progressManager(pbSecundario)
            seekbarManager(sbNormal)
        }

        // RATING BAR
        var rbRating = findViewById<RatingBar>(R.id.ratingBar)
        var tvRating = findViewById<TextView>(R.id.tvRating)
        rbRating.rating = 2.5f
        rbRating.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            tvRating.text = "${rating}/${ratingBar.numStars}"
        }
    }

    private fun progressManager(pb: ProgressBar) {
        while (pb.progress < pb.max) {
            Thread.sleep(100L)
            pb.incrementProgressBy(5)
            if (pb.id == R.id.pbSecundaria) {
                pb.incrementSecondaryProgressBy(10)
            }
        }
    }

    private fun seekbarManager(sb: SeekBar) {
        while (true) {
            Thread.sleep(100L)
            sb.incrementProgressBy(5)
        }
    }
}