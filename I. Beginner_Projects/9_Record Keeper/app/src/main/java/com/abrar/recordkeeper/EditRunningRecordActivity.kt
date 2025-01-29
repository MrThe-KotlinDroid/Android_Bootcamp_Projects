package com.abrar.recordkeeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abrar.recordkeeper.databinding.ActivityEditRunningRecordBinding

class EditRunningRecordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRunningRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_running_record)

    }
}