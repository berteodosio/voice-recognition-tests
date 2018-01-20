package com.movile.testvoiceinteractor

import android.app.VoiceInteractor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prompt = TestConfirmationRequest()
        Log.e("POTATO", "Voiceinteractor = $voiceInteractor")
        voiceInteractor?.submitRequest(prompt)
    }

    class TestConfirmationRequest : VoiceInteractor.ConfirmationRequest(VoiceInteractor.Prompt(arrayOf("Hey dude, what are u waiting for?"), "Second parameter"), null) {

        override fun onConfirmationResult(confirmed: Boolean, result: Bundle?) {
            super.onConfirmationResult(confirmed, result)
            Log.e("POTATO", "Confirmed = $confirmed")
        }
    }
}
