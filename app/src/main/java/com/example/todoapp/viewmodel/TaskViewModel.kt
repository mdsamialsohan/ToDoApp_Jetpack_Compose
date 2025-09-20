package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.Task
import com.example.todoapp.data.database.TodoDatabase
import com.example.todoapp.data.repo.TaskRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    private val getAllTodo: LiveData<List<Task>>
    private val repository: TaskRepo

    init{
        val taskDao = TodoDatabase.getDatabase(application).taskDao()
        repository = TaskRepo(taskDao)
        getAllTodo = repository.getAllTodo
    }

    fun getTasks(): LiveData<List<Task>> = getAllTodo

    fun addTask(task:Task){
        if(task.title.isNotBlank())
        {
            viewModelScope.launch (Dispatchers.IO){
                repository.addTask(task)
            }
        }
    }
    fun remove(task: Task)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeTask(task)
        }
    }
    fun toggleTaskCompletion(task:Task)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.toggleTaskComplete(task)
        }
    }
}