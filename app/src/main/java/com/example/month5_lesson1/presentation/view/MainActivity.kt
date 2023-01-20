package com.example.month5_lesson1.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.month5_lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var ui: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initialize()
    }

    private fun initialize() {
        ui.rvMain.adapter = NumberAdapter()
    }
}