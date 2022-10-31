package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val nameTv = findViewById<EditText>(R.id.nameTv)

        startBtn.setOnClickListener {
            if (nameTv.text.isNotEmpty()){
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