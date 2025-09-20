package com.example.todoapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoapp.data.Task

@Dao
interface TaskDao{
    @Query("SELECT * FROM Task ORDER BY id ASC")
    fun getAllTOdo():LiveData<List<Task>>

    @Insert
    fun addTodo(task: Task)

    @Query("DELETE FROM Task WHERE id = :id")
    fun deleteTodo(id: Int)

    @Query("UPDATE Task SET isCompleted = NOT isCompleted WHERE id= :id")
    fun toggleTodoCompletion(id:Int)
}