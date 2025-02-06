package com.abrar.activitylifecycleplayground

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.abrar.activitylifecycleplayground.databinding.ActivityMainBinding
import java.util.Timer
import kotlin.concurrent.fixedRateTimer

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
        binding.buttonExit.setOnClickListener {
            finish()
        }


    }

    override fun onResume() {
        super.onResume()
        timer = fixedRateTimer(period = 1000L) {
            runOnUiThread {
                seconds++
                binding.textViewTimer.text = "You have been staring at this screen for $seconds seconds"
            }
        }
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }


}