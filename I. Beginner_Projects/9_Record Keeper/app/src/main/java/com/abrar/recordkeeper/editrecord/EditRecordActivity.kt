package com.abrar.recordkeeper.editrecord

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.abrar.recordkeeper.databinding.ActivityEditRecordBinding

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding

    private val screenData: ScreenData by lazy {
        intent.getSerializableExtra("ScreenData") as ScreenData
    }

    private val recordPreferences by lazy { getSharedPreferences("RunningRecords", MODE_PRIVATE) }
    private val record by lazy { intent.getStringExtra("Distance") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setupUi()
        displayRecord()
    }

    private fun setupUi() {
        title = "Edit $record Record"
        binding.buttonSave.setOnClickListener {
            saveRecord()
            finish()
        }
        binding.buttonDelete.setOnClickListener {
            clearRecord()
            finish()
        }
    }


    private fun displayRecord() {

        binding.editTextRecord.setText(recordPreferences.getString("$record record", null))
        binding.editTextDate.setText(recordPreferences.getString("$record date", null))
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        recordPreferences.edit {
            putString("${this@EditRecordActivity.record} record", record)
            putString("${this@EditRecordActivity.record} date", date)

            Toast.makeText(this@EditRecordActivity, "Record saved", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove ("$record record")
            remove ("$record date")
        }
        Toast.makeText(this, "Record deleted", Toast.LENGTH_SHORT).show()
    }

    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String
    )
}