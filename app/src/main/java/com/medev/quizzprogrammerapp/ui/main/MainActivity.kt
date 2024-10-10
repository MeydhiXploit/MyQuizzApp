package com.medev.quizzprogrammerapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.medev.quizzprogrammerapp.R
import com.medev.quizzprogrammerapp.databinding.ActivityMainBinding
import com.medev.quizzprogrammerapp.repository.Repository
import com.medev.quizzprogrammerapp.ui.prepare.PrepareActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onClick()
        val contents = Repository.getDataContents(this)
        Log.d("MainActivity", "onCreate:size: ${contents?.size}")
        Log.d("MainActivity", "onCreate: ${contents?.get(0)?.body}")
        Log.d("MainActivity", "onCreate: ${contents?.get(0)?.answers?.get(0)?.answer}")

    }

    private fun onClick() {
        mainBinding.btnPlay.setOnClickListener {
            startActivity(Intent(this, PrepareActivity::class.java))
        }
    }
}