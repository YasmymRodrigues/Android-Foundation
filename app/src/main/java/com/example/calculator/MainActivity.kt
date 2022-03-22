package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        viewId.setOnClickListener {
            Log.i(TAG,"motorstart")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}