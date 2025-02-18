package com.abrar.activitylifecycleplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abrar.activitylifecycleplayground.databinding.ActivityMainBinding
import java.io.File
import java.util.Timer

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var seconds = 0
    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.buttonExit.setOnClickListener { showDialog() }

        val callback = onBackPressedDispatcher.addCallback { showDialog() }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        val userMessage = binding.editTextMessage.text
//        File(filesDir, "user message.txt").writeText(userMessage.toString())
//    }

    fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Warning!")
            .setMessage("You are about to leave the app. Are you sure you want to exit?")
            .show()
    }
}