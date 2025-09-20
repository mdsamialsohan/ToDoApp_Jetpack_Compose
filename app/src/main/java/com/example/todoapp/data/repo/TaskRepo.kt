package com.example.todoapp.data.repo

import androidx.lifecycle.LiveData
import com.example.todoapp.data.Task
import com.example.todoapp.data.dao.TaskDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskRepo (private val taskDao: TaskDao){

    val getAllTodo: LiveData<List<Task>> = taskDao.getAllTOdo()

    suspend fun addTask(task: Task){
        taskDao.addTodo(task)
    }
    suspend fun removeTask(task: Task){
        taskDao.deleteTodo(task.id)
    }
    suspend fun toggleTaskComplete(task:Task)
    {
       taskDao.toggleTodoCompletion(task.id)
    }


}