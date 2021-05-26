package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        MainScope().launch(Dispatchers.IO) {
            val text = sendGet()
            runOnUiThread{
                findViewById<TextView>(R.id.TextView).text = text
            }
        }
    }
}


fun sendGet() : String{
    val response = URL("https://chrome.google.com/webstore/category/extensions?hl=ru").readText()
    Log.d("OUTPUT", response)
    return response
}