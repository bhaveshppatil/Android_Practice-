package com.example.animalsprofileinafragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment()
    }

    private fun launchFragment() {
        fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val animalFragment = AnimalFragment()
        fragmentTransaction.add(R.id.fragment_container_view_tag, animalFragment, "animalFragment")
            .addToBackStack("animal").commit()
    }
}