package com.example.navigationgraph_iw.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.navigationgraph_iw.PreviewActivity
import com.example.navigationgraph_iw.R
import kotlinx.android.synthetic.main.fragment_student_performnce.*


class studentPerformanceFragment : Fragment(R.layout.fragment_student_performnce) {

    private lateinit var name: String
    private var age: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataFromStudentDetails()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPreview.setOnClickListener {
            val grade = etStudentGrade.text.toString()
            val perc = etStudentPercentage.text.toString()

            val intent = Intent(context, PreviewActivity::class.java)

            intent.putExtra("grade", grade)
            intent.putExtra("perc", perc)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            startActivity(intent)
        }
    }

    private fun getDataFromStudentDetails() {
        arguments?.run {
            name = getString("name")!!
            age = getInt("age")

        }
    }
}