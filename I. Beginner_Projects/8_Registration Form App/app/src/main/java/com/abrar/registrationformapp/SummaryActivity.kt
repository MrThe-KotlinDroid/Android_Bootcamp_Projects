package com.abrar.registrationformapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_summary.text_view_email_address
import kotlinx.android.synthetic.main.activity_summary.text_view_phone
import kotlinx.android.synthetic.main.activity_summary.text_view_user_full_name

class SummaryActivity : AppCompatActivity() {

    private lateinit var user: UserInformation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("UserInformation") as UserInformation
    }

    private fun displayUser() {
        text_view_user_full_name.text = user.getFullName()
        text_view_email_address.text = user.email
        text_view_phone.text = user.phone
    }

    private fun setupClickListeners() {
        text_view_email_address.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }

        text_view_phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }
    }

}



