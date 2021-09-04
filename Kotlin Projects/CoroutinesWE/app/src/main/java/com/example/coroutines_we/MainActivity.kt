package com.example.coroutines_we

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            CoroutineScope(Dispatchers.IO).launch {
                Log.d("Coroutines", "launch")
                val  data = getDataFromApi()
                Log.d("Coroutines", "First Coroutines $data")

                val wait  = async {
                    val data = getDataFromApi()
                    return@async data
                }.await()

                val res2  = async {
                    val data2 = getDataFromApi()
                    return@async data2
                }.await()

                CoroutineScope(Dispatchers.Main).launch {
                    tvTextView.text = "$data + $res2"
                    Log.d("Coroutines", "Second Coroutines $wait + $res2")
                }

            }
        }
    }

    suspend fun getDataFromApi(): String {
        delay(6000);
        return "Data fetch Successfully"
    }
}


/*
            val wait  = async {
                val data = getDataFromApi()
                return@async data
            }.await()

 */