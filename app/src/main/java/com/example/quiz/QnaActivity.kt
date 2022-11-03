package com.example.quiz

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quiz.databinding.ActivityQnaBinding

class QnaActivity : AppCompatActivity(),OnClickListener {
    private lateinit var binding: ActivityQnaBinding

    private var mCurrentPosition : Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qna)

        binding = ActivityQnaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mQuestionsList = Constants.getQuestion() // Constants에서 질문과 대답, 국기 등이 당긴 리스트 받아옴
        setQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        val question: Question = mQuestionsList!![mCurrentPosition - 1] // questionList에서 인덱스 번호에 해당하는 것들을 담은 변수 생성

        binding.progressBar.progress = mCurrentPosition // progressBar에 지점을 위치를 나타내는 변수로 지정
        binding.progressBarText.text =
            "${mCurrentPosition}/${binding.progressBar.max}" // progressBarText를 위치를 나타내는 변수로 지정
        binding.tvQuestion.text = question.question // 질문을 question에 질문으로 지정

        binding.tvImage.setImageResource(question.image) // 이미지를 question에 이미지로 지정

        // 답변을 question에 답변으로 지정

        binding.tvOptionOne.text = question.option1
        binding.tvOptionTwo.text = question.option2
        binding.tvOptionThree.text = question.option3
        binding.tvOptionFour.text = question.option4

        if(mCurrentPosition == mQuestionsList!!.size){
            binding.btnSubmit.text = "제출"
        }
        else{
            binding.btnSubmit.text = "다음"
        }

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        binding.tvOptionOne.let {
            options.add(0,it)
        }
        binding.tvOptionTwo.let {
            options.add(1,it)
        }
        binding.tvOptionThree.let {
            options.add(2,it)
        }
        binding.tvOptionFour.let {
            options.add(3,it)
        }

        for (i in options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface = Typeface.DEFAULT
            i.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_option_one -> {
                selectedOptionView(binding.tvOptionOne,1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(binding.tvOptionTwo,2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(binding.tvOptionThree,3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(binding.tvOptionFour,4)
            }
            R.id.btn_submit -> {
                // TODO "wait"
            }
        }
    }
}