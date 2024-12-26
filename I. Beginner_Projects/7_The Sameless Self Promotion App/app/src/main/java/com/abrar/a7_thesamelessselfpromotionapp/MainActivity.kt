package com.abrar.a7_thesamelessselfpromotionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_preview.setOnClickListener {
            onPreviewClicked()
        }
    }


    private fun onPreviewClicked() {
        val contactName = edit_text_contact_name.text.toString()
        val contactNumber = edit_text_contact_number.text.toString()
        val myDisplayName = edit_text_display_name.text.toString()
        val includeJunior = check_box_include_junior.isChecked
        val jonDescription = spinner_job_title.selectedItem.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.text.toString()
    }
}