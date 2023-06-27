package com.example.theroos.speechtotext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

private val RQ_SPEECH_REC = 102

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnspeech = findViewById<Button>(R.id.btn_speech)

        btnspeech.setOnClickListener {
            speechtotext()
        }
    }

    private fun speechtotext() {
        TODO("Not yet implemented")
    }
}