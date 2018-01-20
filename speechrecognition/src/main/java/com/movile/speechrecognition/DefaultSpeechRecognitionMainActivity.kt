package com.movile.speechrecognition

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log

class DefaultSpeechRecognitionMainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE = 173
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tryToRecognize()
    }

    private fun tryToRecognize() {
        startActivityForResult(mountRecognizerIntent(), REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != REQUEST_CODE) {
            return
        }

        if (resultCode != Activity.RESULT_OK) {
            return
        }

        val matches = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS) ?: emptyList<String>()
        matches.forEach {
            Log.e("POTATO", "This is a match: $it")
        }
    }
}
