package com.bhavesh.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bhavesh.myapplication.R
import com.bhavesh.myapplication.`interface`.ClickListener
import com.bhavesh.myapplication.*
import java.lang.Exception
import android.widget.Button

import android.widget.TextView

import com.bhavesh.myapplication.*


class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var textView: TextView

    private lateinit var buttonListener: ClickListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            buttonListener = activity as ClickListener
        } catch (e: Exception) {
            Log.d("Tag", e.toString())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnFirst = view.findViewById<Button>(R.id.btnFirst)
        textView = view.findViewById<TextView>(R.id.tvFirstFrag)

        btnFirst.setOnClickListener {
            buttonListener.onButtonPressed("Message from first fragment")
        }
    }

    fun onFragmentActionSec(msg: String) {
        textView.text = msg
    }
}