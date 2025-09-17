package com.example.todoapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.ui.components.TaskInputDialog
import com.example.todoapp.ui.components.TaskItem
import com.example.todoapp.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    taskViewModel: TaskViewModel = viewModel()
)
{
    val tasks by taskViewModel.tasks.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick ={showDialog = true},
                content = {
                    Icon(Icons.Default.Add, contentDescription = "Add ToDo")
                }
            )
        },
        topBar = {
            Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Max)
                    .background(MaterialTheme.colorScheme.primary)
                .statusBarsPadding(),
                contentAlignment = Alignment.Center
            ){
                Text( text = "To Do App",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

    ){
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
    if(showDialog){
        TaskInputDialog(
            onDismiss = {showDialog = false},
            onConfirm = {
                taskViewModel.addTask(it)
                showDialog = false
            }
        )
    }
}