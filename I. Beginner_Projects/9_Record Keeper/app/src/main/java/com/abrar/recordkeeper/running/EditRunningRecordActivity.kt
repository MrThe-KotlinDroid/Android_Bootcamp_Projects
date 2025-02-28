package com.abrar.recordkeeper.running

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.abrar.recordkeeper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunningRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditRunningRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val distance = intent.getStringExtra("Distance")
        title = "$distance Record"

        val applicationPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        applicationPreferences.edit {
            putString("Some application data", "Application preference value here")
        }

        val activityPreferences = getPreferences(Context.MODE_PRIVATE)

        activityPreferences.edit {
            putInt("Some activity data", 15)
        }

        val fileNamePreferences = getSharedPreferences("Some shared preferences file", Context.MODE_PRIVATE)
        fileNamePreferences.edit {
            putBoolean("Some preference file name data", false)
        }

    }
}