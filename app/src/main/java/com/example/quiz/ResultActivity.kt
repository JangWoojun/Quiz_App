package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.databinding.ActivityQnaBinding
import com.example.quiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalQuestions = intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        val correctAnswers = intent.getStringExtra(Constants.CORRECT_ANSWERS)

        binding.tvName.text = intent.getStringExtra(Constants.USER_NAME)
        binding.tvResult.text = "${totalQuestions}개 문제 중 ${correctAnswers}개 문제를 맞으셨습니다"

    }
}