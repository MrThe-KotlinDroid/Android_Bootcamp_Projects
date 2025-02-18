package com.abrar.activitylifecycleplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abrar.activitylifecycleplayground.databinding.ActivityMainBinding
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
        binding.buttonExit.setOnClickListener { finish() }

        val callback = onBackPressedDispatcher.addCallback {
            Toast.makeText(this@MainActivity, "In the back button callback", Toast.LENGTH_LONG).show()
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        val userMessage = binding.editTextMessage.text
//        File(filesDir, "user message.txt").writeText(userMessage.toString())
//    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(this, "Back button pressed", Toast.LENGTH_SHORT).show()
    }
}