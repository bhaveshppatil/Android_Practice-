package com.example.events_navfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_event_details.*


class EventDetailsFragment : Fragment(R.layout.fragment_event_details) {

    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnNext.setOnClickListener {
            val bundle = Bundle()
            val eventName = etEventName.text.toString()
            val eventDesc = etEventDecs.text.toString()

            bundle.putString("eventName", eventName)
            bundle.putString("eventDesc", eventDesc)
            navController.navigate(R.id.action_eventDetailsFragment_to_timeAndDateFragment, bundle)

        }
    }

}