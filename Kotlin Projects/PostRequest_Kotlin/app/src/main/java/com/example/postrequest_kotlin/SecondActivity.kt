package com.example.postrequest_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent

        val id = intent.getIntExtra("id", 0)
        val email = intent.getStringExtra("email")
        val title = intent.getStringExtra("title")
        val request = intent.getStringExtra("request")

        tvTitle.text = ("Title: $title")
        tvEmail.text = ("Email:$email")
        tvRequestType.text = ("Request Type: $request")
        tvPasswd.text = ("ID: $id")
    }
}