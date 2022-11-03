package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quiz.databinding.ActivityQnaBinding

class QnaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQnaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qna)

        binding = ActivityQnaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}