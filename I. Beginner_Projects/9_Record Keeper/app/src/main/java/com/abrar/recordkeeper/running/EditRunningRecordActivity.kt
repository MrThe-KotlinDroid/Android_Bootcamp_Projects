package com.abrar.recordkeeper.running

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.abrar.recordkeeper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunningRecordBinding
    private val runningPreferences by lazy { getSharedPreferences("RunningRecords", MODE_PRIVATE)}
    private val distance by lazy { intent.getStringExtra("Distance") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayRecord()
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
    }

    private fun displayRecord() {

        binding.editTextRecord.setText(runningPreferences.getString("$distance record", null) )
        binding.editTextDate.setText(runningPreferences.getString("$distance date", null) )
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        runningPreferences.edit {
            putString("$distance record", record)
            putString("$distance date", date)

            Toast.makeText(this@EditRunningRecordActivity, "Record saved", Toast.LENGTH_SHORT).show()
        }
    }
}