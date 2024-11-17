package com.abrarhamim.mymarketingapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.button_preview
import kotlinx.android.synthetic.main.activity_main.check_box_immediate_start
import kotlinx.android.synthetic.main.activity_main.check_box_junior
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_name
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_number
import kotlinx.android.synthetic.main.activity_main.edit_text_my_display_name
import kotlinx.android.synthetic.main.activity_main.edit_text_start_date
import kotlinx.android.synthetic.main.activity_main.spinner_job_title

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
        val myDisplayName = edit_text_my_display_name.text.toString()
        val includeJunior = check_box_junior.isChecked
        val jobDescription = spinner_job_title.selectedItem.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.text.toString()

        //Random git push

        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
    }
}