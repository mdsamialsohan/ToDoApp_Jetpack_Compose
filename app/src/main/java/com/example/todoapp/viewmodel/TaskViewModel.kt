package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.Task
import com.example.todoapp.data.repo.TaskRepo
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel: ViewModel() {
    private val repo = TaskRepo()
    val tasks: StateFlow<List<Task>> = repo.tasks

    init{
        if(tasks.value.isEmpty())
            repo.addTask(Task(
                title = "Shopping befor 12 am",
                id = 1,
                isCompleted = true
            ))
        repo.addTask(Task(
            title = "Having Lunch ",
            id = 2,
            isCompleted = false
        ))
        repo.addTask(Task(
            title = "Visit a park",
            id = 3,
            isCompleted = true
        ))
    }
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