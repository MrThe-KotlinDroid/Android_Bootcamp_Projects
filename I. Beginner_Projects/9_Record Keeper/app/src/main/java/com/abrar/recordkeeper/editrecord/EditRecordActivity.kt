package com.abrar.recordkeeper.editrecord

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.abrar.recordkeeper.databinding.ActivityEditRecordBinding
import java.io.Serializable

const val INTENT_EXTRA_SCREEN_DATA = "screen_data"

class EditRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRecordBinding

    private val screenData: ScreenData by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(INTENT_EXTRA_SCREEN_DATA, ScreenData::class.java) as ScreenData
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(INTENT_EXTRA_SCREEN_DATA) as ScreenData
        }
    }


    private val recordPreferences by lazy {
        getSharedPreferences(
            screenData.sharedPreferencesName,
            MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUi()
        displayRecord()
    }

    private fun setupUi() {
        title = "Edit ${screenData.record} Record"
        binding.textInputRecord.hint = screenData.recordFieldHint
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

        binding.editTextRecord.setText(recordPreferences.getString("${screenData.record} $SHARED_PREFERENCES_RECORD_KEY", null))
        binding.editTextDate.setText(recordPreferences.getString("${screenData.record} $SHARED_PREFERENCES_DATE_KEY", null))
    }

    private fun saveRecord() {
        val record = binding.editTextRecord.text.toString()
        val date = binding.editTextDate.text.toString()

        recordPreferences.edit {
            putString("${this@EditRecordActivity.screenData.record} record", record)
            putString("${this@EditRecordActivity.screenData.record} date", date)

            Toast.makeText(this@EditRecordActivity, "Record saved", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun clearRecord() {
        recordPreferences.edit {
            remove("${screenData.record} $SHARED_PREFERENCES_RECORD_KEY")
            remove("${screenData.record} $SHARED_PREFERENCES_DATE_KEY")
        }
        Toast.makeText(this, "Record deleted", Toast.LENGTH_SHORT).show()
    }

    data class ScreenData(
        val record: String,
        val sharedPreferencesName: String,
        val recordFieldHint: String
    ) : Serializable

    companion object {
        const val SHARED_PREFERENCES_RECORD_KEY = "record"
        const val SHARED_PREFERENCES_DATE_KEY = "date"
    }
}