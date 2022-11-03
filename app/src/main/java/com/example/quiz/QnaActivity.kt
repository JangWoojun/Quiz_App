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

        val questionList = Constants.getQuestion()
        var currentPosition = 1
        val question : Question = questionList[currentPosition-1]
        binding.progressBar.progress = currentPosition
        binding.progressBarText.text = "${currentPosition}/${binding.progressBar.max}"
        binding.tvQuestion.text = question.question

        binding.tvImage.setImageResource(question.image)

        binding.tvOptionOne.text = question.option1
        binding.tvOptionTwo.text = question.option2
        binding.tvOptionThree.text = question.option3
        binding.tvOptionFour.text = question.option4

    }
}