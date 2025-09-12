package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Task
import com.example.todoapp.data.repo.TaskRepo
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel: ViewModel() {
    private val repo = TaskRepo()
    val tasks: StateFlow<List<Task>> = repo.tasks
    fun addTask(title: String){
        if(title.isNotBlank())
        {
            val newTask = Task(id = System.currentTimeMillis().toInt(),title = title)
        }
    }
    fun remove(task: Task)
    {
        repo.removeTask(task)
    }
    fun toggleTaskCompletion(task:Task)
    {
        repo.toggleTaskComplete(task)
    }
}