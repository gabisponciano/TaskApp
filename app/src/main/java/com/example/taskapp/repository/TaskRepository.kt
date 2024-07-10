package com.example.taskapp.repository

import com.example.taskapp.db.TaskDao
import com.example.taskapp.models.ModelTasks
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class TaskRepository (
    private val dao: TaskDao
){
    //val allTasks get() = dao.findAll()

    suspend fun insert(task: ModelTasks) = withContext(IO){
        //dao.insertTask()
    }

}

