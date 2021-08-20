package com.example.events_navfragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_price_details.*


class PriceDetailsFragment : Fragment(R.layout.fragment_price_details) {

    private lateinit var eventName: String
    private lateinit var eventDecs: String
    private lateinit var startTime: String
    private lateinit var endTime: String
    private lateinit var startDate: String
    private lateinit var endDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDetailsAndTime()
    }

    private fun getDetailsAndTime() {
        arguments?.run {
            eventName = getString("eventName").toString()
            eventDecs = getString("eventDecs").toString()
            startTime = getString("startTime").toString()
            endTime = getString("endTime").toString()
            startDate = getString("startDate").toString()
            endDate = getString("endDate").toString()

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPreview.setOnClickListener {
            val currencyAmount = etCurrency.text.toString()
            val price = etPrice.text.toString().toInt()
            val intent = Intent(context, PreviewActivity::class.java)

            intent.putExtra("eventName", eventName)
            intent.putExtra("eventDecs", eventDecs)
            intent.putExtra("startTime", startTime)
            intent.putExtra("endTime", endTime)
            intent.putExtra("startDate", startDate)
            intent.putExtra("endDate", endDate)
            intent.putExtra("price", price)

            startActivity(intent)
        }
    }
}