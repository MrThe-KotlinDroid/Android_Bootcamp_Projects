package com.example.getitdone.ui

import androidx.lifecycle.ViewModel
import com.example.getitdone.data.Task

class MainViewModel : ViewModel() {

    fun createTask(title: String, description: String?) {
        val task = Task(
            title = title,
            description = description
        )
        // save the task here
    }

}