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
        binding.buttonSave.setOnClickListener { saveMessage() }
        binding.buttonShowFragment.setOnClickListener { showFragment() }
        binding.buttonRemoveFragment.setOnClickListener { removeFragment() }
        val callback = onBackPressedDispatcher.addCallback { showDialog() }

        binding.textViewSavedMessage.text = savedInstanceState?.getString("savedMessage")
    }

    private fun showFragment() {

    }

    private fun removeFragment() {

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val savedTextViewMessage = binding.textViewSavedMessage.text.toString()
        outState.putString("savedMessage", savedTextViewMessage)
    }

    private fun saveMessage() {
        val userMessage = binding.editTextMessage.text
        File(filesDir, "user message.txt").writeText(userMessage.toString())
        binding.textViewSavedMessage.text =
            "Your message has been saved!\n\nMessage Preview:\n\n$userMessage"
        binding.editTextMessage.setText("")
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Warning!")
//            .setMessage("You are about to leave the app. Are you sure you want to exit?")
            .setView(R.layout.dialog_warning)
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .setNeutralButton("More info") { dialog, _ ->
                Toast.makeText(
                    this,
                    "This is where the more info screen could be!",
                    Toast.LENGTH_LONG
                ).show()
                dialog.dismiss()
            }
            .show()
    }
}