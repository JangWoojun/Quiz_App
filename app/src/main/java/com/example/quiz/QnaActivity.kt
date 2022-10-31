package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class QnaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qna)
        val questionsList = Constants.getQuestion()

    }
}