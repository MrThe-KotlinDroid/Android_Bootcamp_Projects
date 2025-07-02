package com.example.getitdone.ui.tasks

import androidx.lifecycle.ViewModel
import com.example.getitdone.GetItDoneApplication
import com.example.getitdone.data.Task

class TasksViewModel : ViewModel() {

    val taskDao = GetItDoneApplication.taskDao

    fun fetchTasks() {

    }

    fun updateTask(task: Task) {

    }

    fun deleteTask(task: Task) {

    }

}