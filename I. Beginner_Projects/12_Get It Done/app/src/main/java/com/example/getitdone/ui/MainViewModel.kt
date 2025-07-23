package com.example.getitdone.ui

import androidx.lifecycle.ViewModel
import com.example.getitdone.GetItDoneApplication
import com.example.getitdone.data.Task
import kotlin.concurrent.thread

class MainViewModel : ViewModel() {

    private val taskDao = GetItDoneApplication.taskDao

    fun createTask(title: String, description: String?) {
        val task = Task(
            title = title,
            description = description
        )
        thread {
            taskDao.createTask(task)
        }
        // save the task here
    }

}