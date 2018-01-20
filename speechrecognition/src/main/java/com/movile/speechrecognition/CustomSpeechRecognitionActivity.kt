package com.movile.speechrecognition

import android.os.Bundle
import android.speech.SpeechRecognizer
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_custom.*

class CustomSpeechRecognitionActivity : AppCompatActivity() {

    private val speechRecognizer by lazy { SpeechRecognizer.createSpeechRecognizer(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
        speechRecognizer.setRecognitionListener(SpeechRecognitionListener(results_text))
        initializeListeners()
    }

    private fun initializeListeners() {
        start_button?.setOnClickListener { speechRecognizer.startListening(mountRecognizerIntent()) }
        stop_button?.setOnClickListener { speechRecognizer.stopListening() }
    }

    class SpeechRecognitionListener(private val textView: TextView) : BaseRecognitionListener() {

        override fun onResults(results: Bundle?) {
            val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) ?: emptyList<String>()
            matches.forEach {
                textView.text = "${textView.text}\n$it"
                Log.e("POTATO", "This is a CUSTOM match: $it")
            }
        }
    }
}