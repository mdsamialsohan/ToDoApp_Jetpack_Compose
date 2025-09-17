package com.example.todoapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.components.TaskItem
import com.example.todoapp.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    taskViewModel: TaskViewModel = viewModel()
)
{
    val tasks by taskViewModel.tasks.collectAsState()
    Scaffold {
        paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            LazyColumn {
                items(tasks){
                    tasks->
                    TaskItem(
                        task = tasks,
                        onToggleComplete = {taskViewModel.toggleTaskCompletion(it)},
                        onDelete = { taskViewModel.remove(it)}
                    )
                }
            }
        }
    }
}