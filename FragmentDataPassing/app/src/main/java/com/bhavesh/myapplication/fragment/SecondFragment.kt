package com.bhavesh.myapplication.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bhavesh.myapplication.R
import com.bhavesh.myapplication.`interface`.ClickListener
import java.lang.Exception


class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var textView: TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById(R.id.tvSecFrag)
       val button = view.findViewById<Button>(R.id.btnSecond)
        button.setOnClickListener {
            buttonListener.onSecondBtnPressed("msg from second fragment")
        }
    }

    private lateinit var buttonListener: ClickListener
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            buttonListener = activity as ClickListener
        } catch (e: Exception) {
            Log.d("Tag", e.toString())
        }
    }


    fun onFragmentAction(msg : String){
        textView.text = msg
    }
}