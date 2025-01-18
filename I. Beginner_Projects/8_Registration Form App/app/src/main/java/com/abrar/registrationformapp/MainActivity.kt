package com.abrar.registrationformapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button_create_account
import kotlinx.android.synthetic.main.activity_main.edit_text_email
import kotlinx.android.synthetic.main.activity_main.edit_text_first_name
import kotlinx.android.synthetic.main.activity_main.edit_text_last_name
import kotlinx.android.synthetic.main.activity_main.edit_text_phone
import kotlinx.android.synthetic.main.activity_main.spinner_title

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner()
        setupButton()

    }

    private fun setupSpinner() {
        val titles: Array<String> = arrayOf("Miss", "Mr", "Mrs", "Ms", "Mx", "Dr", "Prof")
        val titleAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, titles)
        spinner_title.adapter = titleAdapter
    }

    private fun setupButton() {
        button_create_account.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val userInformation = UserInformation(
            spinner_title.selectedItem as String,
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email.text.toString(),
            edit_text_phone.text.toString()
        )

        val summaryActivityIntent = Intent(this, SummaryActivity::class.java)
        summaryActivityIntent.putExtra("UserInformation", userInformation)

        startActivity(summaryActivityIntent)
    }
}