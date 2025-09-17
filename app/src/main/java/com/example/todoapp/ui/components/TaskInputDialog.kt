package com.example.todoapp.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskInputDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    var taskInput by rememberSaveable { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add To Do") },
        text = {
            TextField(
                value = taskInput,
                onValueChange = { taskInput = it },
                placeholder = { Text("Enter new To Do") }
            )
        },
        confirmButton = {
            Button(onClick = {
                if (taskInput.isNotBlank()) {
                    onConfirm(taskInput)
                    taskInput = ""
                }
            }) {
                Text("Add")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TextInputDialogPreview() {
    TaskInputDialog(onDismiss = {}, onConfirm = {})
}
