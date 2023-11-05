package com.example.kotlincoroutines

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var counter = 1
    private var counter1 = 0
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add1.setOnClickListener {

            add1()
        }
        binding.button2.setOnClickListener {
            CoroutineScope(Dispatchers.IO)
                .launch {
                    DownlodData()


                }

        }


    }

    @SuppressLint("SetTextI18n")
    private suspend fun DownlodData() {
        for (i in 1..100000) {
            Log.i("TAGD", "Downloding $i in ${Thread.currentThread().name}")


            withContext(Dispatchers.Main){
                Log.i("TAGD", "Downloding $i in ${Thread.currentThread().name}")
                binding.textView.text = "$i in ${Thread.currentThread().name}"


            }

        }
    }

    private fun add1() {
        val c = counter++
        binding.textView2.text = c.toString()

    }
}