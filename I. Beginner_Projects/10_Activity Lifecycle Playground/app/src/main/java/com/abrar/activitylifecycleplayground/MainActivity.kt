package com.abrar.activitylifecycleplayground

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.button_exit).setOnClickListener {
            Log.d("Abrar Hamim", "In the button click listener!, Exiting the app!")
            finish()
        }
        Log.d("Abrar Hamim", "I'm in onCreate()!")
    }

    // When our Activity becomes visible to the user
    override fun onStart() {
        super.onStart()
        Log.d("Abrar Hamim", "I'm now in onStart()!")
    }

    // When our Activity is in the foreground and the user can interact with it
    override fun onResume() {
        super.onResume()
        Log.d("Abrar Hamim", "I'm now in onResume()!")
    }

    // When our Activity is still visible, but it is in the background
    // (e.g. An Activity "Dialog" is on top, but we can still see our Activity
    override fun onPause() {
        super.onPause()
        Log.d("Abrar Hamim", "I'm now in onPause()!")
    }

    // When our Activity is no longer visible (but it's running)
    override fun onStop() {
        super.onStop()
        Log.d("Abrar Hamim", "I'm now in onStop()!")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Abrar Hamim", "I'm now in onDestroy()!")
    }
}