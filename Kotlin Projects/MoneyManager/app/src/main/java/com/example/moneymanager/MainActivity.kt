package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val splashIntent = Intent(this@MainActivity, MoneyManager::class.java)
            startActivity(splashIntent)
            finish()
        }, 3000)
    }
}