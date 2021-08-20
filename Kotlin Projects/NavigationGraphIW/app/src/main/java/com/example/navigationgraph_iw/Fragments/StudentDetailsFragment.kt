package com.example.navigationgraph_iw.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationgraph_iw.R
import kotlinx.android.synthetic.main.fragment_student_details.*

class StudentDetailsFragment : Fragment(R.layout.fragment_student_details) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnNext.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putInt("age", age)
            navController.navigate(R.id.action_studentDetailsFragment_to_studentPerformanceFragment, bundle)
        }
    }
}