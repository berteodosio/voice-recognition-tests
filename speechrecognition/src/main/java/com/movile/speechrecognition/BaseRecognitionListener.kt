package com.movile.speechrecognition

import android.os.Bundle
import android.speech.RecognitionListener

open class BaseRecognitionListener : RecognitionListener {

    override fun onReadyForSpeech(params: Bundle?) {
        // TODO implement method body
    }

    override fun onRmsChanged(rmsdB: Float) {
        // TODO implement method body
    }

    override fun onBufferReceived(buffer: ByteArray?) {
        // TODO implement method body
    }

    override fun onPartialResults(partialResults: Bundle?) {
        // TODO implement method body
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
        // TODO implement method body
    }

    override fun onBeginningOfSpeech() {
        // TODO implement method body
    }

    override fun onEndOfSpeech() {
        // TODO implement method body
    }

    override fun onError(error: Int) {
        // TODO implement method body
    }

    override fun onResults(results: Bundle?) {
        // TODO implement method body
    }
}