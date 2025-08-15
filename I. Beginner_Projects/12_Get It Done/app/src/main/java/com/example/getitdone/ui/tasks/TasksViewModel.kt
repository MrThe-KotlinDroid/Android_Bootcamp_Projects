package com.example.getitdone.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.getitdone.GetItDoneApplication
import com.example.getitdone.data.TaskRepository
import com.example.getitdone.data.model.Task
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {

    private val repository: TaskRepository = GetItDoneApplication.taskRepository

    suspend fun fetchTasks(): List<Task> {
        return repository.getTasks()
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTasks(task)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTasks(task)
        }
    }

}