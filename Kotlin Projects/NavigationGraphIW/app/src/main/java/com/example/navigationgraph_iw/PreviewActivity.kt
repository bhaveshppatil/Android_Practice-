package com.example.navigationgraph_iw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        intent?.run {
            tvStudentName.text = getStringExtra("name")
            tvStudentAge.text = "${getIntExtra("age", 0)}"
            tvStudentGrade.text = getStringExtra("grade")
            tvStudentPercentage.text = getStringExtra("perc")
        }

    }
}