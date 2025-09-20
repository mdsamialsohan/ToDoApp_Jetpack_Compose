package com.example.todoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.data.Task
import com.example.todoapp.data.dao.TaskDao

@Database(entities = [Task::class], version=1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
    companion object{
        @Volatile
        private  var INSTANCE: TodoDatabase?= null
        fun getDatabase(context : Context): TodoDatabase {
            val tempInstance = INSTANCE
            if(tempInstance!=null)
            {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    name = "TODO_Database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}