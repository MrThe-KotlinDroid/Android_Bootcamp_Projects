package com.abrar.a7_thesamelessselfpromotionapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.android.synthetic.main.activity_preview.text_view_message

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        val message = intent.getSerializableExtra("Message") as Message
        val messagePreviewText = """
            Hi ${message.contactName},
            
            My name is ${message.myDisplayName} and I am a
        """.trimIndent()
    }
}