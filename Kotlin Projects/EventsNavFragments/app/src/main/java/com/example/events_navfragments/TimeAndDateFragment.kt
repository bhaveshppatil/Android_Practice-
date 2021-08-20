package com.example.events_navfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_time_and_date.*

class TimeAndDateFragment : Fragment(R.layout.fragment_time_and_date) {

    private lateinit var navController: NavController
    private lateinit var eventName: String
    private lateinit var eventDecs: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getEventDetailsData()
    }

    private fun getEventDetailsData() {
        arguments?.run {
            eventName = getString("eventName").toString()
            eventDecs = getString("eventDecs").toString()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnNextTimeDate.setOnClickListener {
            val startTime = etStartTime.text.toString()
            val endTime = etEndTime.text.toString()
            val startDate = etStartDate.text.toString()
            val endDate = etEndDate.text.toString()

            val bundle = Bundle()
            bundle.putString("startTime", startTime)
            bundle.putString("endTime", endTime)
            bundle.putString("startDate", startDate)
            bundle.putString("endDate", endDate)
            bundle.putString("eventName", eventName)
            bundle.putString("eventDecs", eventDecs)
            navController.navigate(R.id.action_timeAndDateFragment_to_priceDetailsFragment, bundle)

        }
    }
}