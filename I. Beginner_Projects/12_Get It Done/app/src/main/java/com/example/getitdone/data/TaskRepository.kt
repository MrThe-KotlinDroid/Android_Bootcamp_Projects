package com.example.getitdone.data

import com.example.getitdone.data.database.TaskDao
import com.example.getitdone.data.database.TaskListDao
import com.example.getitdone.data.model.Task
import com.example.getitdone.data.model.TaskList
import kotlinx.coroutines.flow.Flow

class TaskRepository(private val taskDao: TaskDao, private val taskListDao: TaskListDao) {

    suspend fun createTask(task: Task) {
        taskDao.createTask(task)
    }

    fun getTasks(taskListId: Int): Flow<List<Task>> {
        return taskDao.getAllTasks(taskListId)
    }

    fun getStarredTasks(): Flow<List<Task>> {
        return taskDao.getStarredTasks()
    }

    suspend fun updateTasks(task: Task) {
        taskDao.updateTask(task)
    }

    suspend fun deleteTasks(task: Task) {
        taskDao.deleteTask(task)
    }

    fun getTaskLists(): Flow<List<TaskList>> {
        return taskListDao.getAllLists()
    }

    suspend fun createTaskList(listName: String) {
        val taskList = TaskList(name = listName)
        taskListDao.createTaskList(taskList)
    }
}