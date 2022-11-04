package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiz.databinding.ActivityQnaBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener {
            if (binding.nameTv.text!!.isNotEmpty()){
                val intent = Intent(this,QnaActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                Toast.makeText(this,"이름을 입력해주세요!",Toast.LENGTH_LONG).show()
            }
        }
    }
}