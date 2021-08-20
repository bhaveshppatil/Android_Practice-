package com.example.events_navfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        intent?.run {
            tvEventName.text = "Event Name : ${getStringExtra("eventName")}"
//            tvEventDecs.text = "Event Description : ${getStringExtra("eventDecs")}"
            tvStartTime.text = "Event Start Time : ${getStringExtra("startTime")}"
            tvEndTime.text = "Event End Time : ${getStringExtra("endTime")}"
            tvStartDate.text = "Event Start Date : ${getStringExtra("startDate")}"
            tvEndDate.text = "Event End Date : ${getStringExtra("endDate")}"
            tvPrice.text = "Event Price : ${getIntExtra("price", 0)}"

        }
    }
}
