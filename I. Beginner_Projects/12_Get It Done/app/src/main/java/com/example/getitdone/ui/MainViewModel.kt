package com.example.getitdone.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getitdone.GetItDoneApplication
import com.example.getitdone.data.TaskRepository
import com.example.getitdone.data.model.Task
import com.example.getitdone.data.model.TaskList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository: TaskRepository = GetItDoneApplication.taskRepository

    fun getTaskList(): Flow<List<TaskList>> = repository.getTaskLists()
    fun createTask(title: String, description: String?) {
        val task = Task(
            title = title,
            description = description
        )
        viewModelScope.launch {
            repository.createTask(task)
        }
    }
}