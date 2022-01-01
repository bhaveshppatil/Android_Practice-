package com.bhavesh.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhavesh.myapplication.`interface`.ClickListener
import com.bhavesh.myapplication.fragment.FirstFragment
import com.bhavesh.myapplication.fragment.SecondFragment

class MainActivity : AppCompatActivity(), ClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonPressed(msg: String) {
        val secondFragment : SecondFragment = supportFragmentManager.findFragmentById(R.id.fragmentSecond) as SecondFragment
        secondFragment.onFragmentAction(msg)
    }

    override fun onSecondBtnPressed(msg: String) {
        val secondFragment : FirstFragment = supportFragmentManager.findFragmentById(R.id.frag_1) as FirstFragment
        secondFragment.onFragmentActionSec(msg)    }
}