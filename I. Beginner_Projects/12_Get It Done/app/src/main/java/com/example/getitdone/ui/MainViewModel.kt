package com.example.getitdone.ui

import androidx.lifecycle.ViewModel
import com.example.getitdone.GetItDoneApplication
import com.example.getitdone.data.Task

class MainViewModel : ViewModel() {

    val taskDao = GetItDoneApplication.taskDao

    fun createTask(title: String, description: String?) {
        val task = Task(
            title = title,
            description = description
        )
        // save the task here
    }

}