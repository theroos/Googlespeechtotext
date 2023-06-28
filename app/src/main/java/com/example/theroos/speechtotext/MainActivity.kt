package com.example.theroos.speechtotext

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import java.util.*

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RQ_SPEECH_REC && resultCode == Activity.RESULT_OK)
        {
            val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            val txtext = findViewById<TextView>(R.id.tv_test)
            txtext.text = result?.get(0).toString()
        }
    }

    private fun speechtotext() {
        if(!SpeechRecognizer.isRecognitionAvailable(this)){
            Toast.makeText(this,"Speech Recognition is not available",Toast.LENGTH_LONG).show()
        } else {
            val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            i.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say Something")
            startActivityForResult(i, RQ_SPEECH_REC)
        }
    }
}