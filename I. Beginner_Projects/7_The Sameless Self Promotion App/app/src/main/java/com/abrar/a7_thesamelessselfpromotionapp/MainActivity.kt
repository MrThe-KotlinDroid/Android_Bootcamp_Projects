package com.abrar.a7_thesamelessselfpromotionapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

private var contactNameEditText: TextInputEditText? = null
private var contactNumberEditText: TextInputEditText? = null
private var myDisplayNameEditText: TextInputEditText? = null
private var startDateEditText: TextInputEditText? = null
private var juniorCheckBox: CheckBox? = null
private var immediateStartCheckBox: CheckBox? = null
private var jobTitleSpinner: Spinner? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contactNameEditText = findViewById(R.id.edit_text_contact_name);
        contactNumberEditText = findViewById(R.id.edit_text_contact_number);
        myDisplayNameEditText = findViewById(R.id.edit_text_display_name);
        startDateEditText = findViewById(R.id.edit_text_start_date);
        juniorCheckBox = findViewById(R.id.check_box_include_junior);
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start);
        jobTitleSpinner = findViewById(R.id.spinner_job_title);

        setContentView(R.layout.activity_main)
        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun onPreviewClicked() {
        val testString = contactNameEditText?.text.toString() + ", " + contactNumberEditText?.text.toString()
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }
}