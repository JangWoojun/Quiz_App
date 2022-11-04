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

        // 해당 버튼들을 클릭 시 밑에서 작성한 onClick 실행
        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionsView() // 질문을 가져올 때마다 초기화
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

        // 만약 mCurrentPosition가 질문 리스트 사이즈와 같아진다면 버튼 텍스트를 마지막 제출로 변경

        if(mCurrentPosition == mQuestionsList!!.size){
            binding.btnSubmit.text = "마지막 제출"
        }
        else{
            binding.btnSubmit.text = "제출"
        }

    }

    private fun defaultOptionsView(){
        // options이라는 ArrayList 해당하는 인덱스 번호에 자신을 담는다
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

        // for문으로 options에서 하나씩 꺼내와 기본상태로 초기화 시킴

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
        // 클릭 할 때마다 초기화 시키는 함수 실행
        defaultOptionsView()
        // 정담 체크를 위해 자신이 클릭한 번호를 저장
        mSelectedOptionPosition = selectedOptionNum
        // 해당하는 버튼에 색을 변경
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(p0: View?) {
        // 클릭 시 해당하는 버튼을 selectedOptionView함수에 넘긴
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
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }
                        else ->{

                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.chk != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    answerView(question.chk,R.drawable.correct_option_border_bg)

                    if (mCurrentPosition == mQuestionsList!!.size){
                        binding.btnSubmit.text = "마지막 제출"
                    }
                    else{
                        binding.btnSubmit.text = "다음 질문으로"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer: Int, drawableView : Int){
        when(answer){
            1 -> {
                binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}