package com.example.todoapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.data.Task
import com.example.todoapp.ui.theme.ToDoAppTheme

@Composable
fun TaskItem(
task: Task,
onToggleComplete: (Task) ->Unit,
onDelete:(Task)-> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { },
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                TaskTitleRow(
                    task = task,
                    onToggleComplete = onToggleComplete
                )
            }
            IconButton(
                onClick = {onDelete(task)},
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                )
            ) {
                Icon(Icons.Default.Delete, contentDescription = "Delete Todo")
            }
        }
    }
}

@Composable
fun TaskTitleRow(
    task: Task,
    onToggleComplete: (Task) -> Unit
) {
    var customColor = Color(0xFF2C46C9)
    var textCustomDecoration = TextDecoration.None
if(task.isCompleted)
{
    customColor = Color(0xFF4CAF50)
    textCustomDecoration = TextDecoration.LineThrough
}
    IconButton(onClick = {onToggleComplete(task)}) {
        Icon(Icons.Default.CheckCircle, contentDescription = "Mark Done", tint = customColor)
    }
    Text(
        text = task.title,
        style = MaterialTheme.typography.bodyLarge.copy(
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        ),
        textDecoration = textCustomDecoration
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskItem() {
    ToDoAppTheme {
//        TaskItem()
    }
}
