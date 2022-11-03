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

        val questionList = Constants.getQuestion() // Constants에서 질문과 대답, 국기 등이 당긴 리스트 받아옴
        var currentPosition = 1 // 위치를 나타내는 변수
        val question : Question = questionList[currentPosition-1] // questionList에서 인덱스 번호에 해당하는 것들을 담은 변수 생성

        binding.progressBar.progress = currentPosition // progressBar에 지점을 위치를 나타내는 변수로 지정
        binding.progressBarText.text = "${currentPosition}/${binding.progressBar.max}" // progressBarText를 위치를 나타내는 변수로 지정
        binding.tvQuestion.text = question.question // 질문을 question에 질문으로 지정

        binding.tvImage.setImageResource(question.image) // 이미지를 question에 이미지로 지정

        // 답변을 question에 답변으로 지정

        binding.tvOptionOne.text = question.option1
        binding.tvOptionTwo.text = question.option2
        binding.tvOptionThree.text = question.option3
        binding.tvOptionFour.text = question.option4

    }
}