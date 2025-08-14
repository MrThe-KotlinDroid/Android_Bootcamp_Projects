package com.example.getitdone.data

import com.example.getitdone.data.database.TaskDao
import com.example.getitdone.data.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun createTask(task: Task) {
        taskDao.createTask(task)
    }

    suspend fun getTasks(): List<Task> {
        return taskDao.getAllTasks()
    }

    suspend fun updateTasks(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTasks(task: Task) {
        taskDao.deleteTask(task)
    }

}