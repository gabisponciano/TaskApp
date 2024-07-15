package com.example.taskapp.repository

import com.example.taskapp.db.TaskDao
import com.example.taskapp.db.TaskEntity
import com.example.taskapp.models.TaskModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


class TaskRepository(
    private val dao: TaskDao
){
    val getAllTasks get() = dao.getAll()

    suspend fun save(task: TaskModel) = withContext(IO) {
        dao.save(task.toEntity())
    }


    suspend fun deleteTask(task: TaskModel) = withContext(IO){
        dao.deleteTask(task.toEntity())
    }
//
//    suspend fun deleteTaskId(id: Int) = withContext(IO){
//        dao.deleteTaskId(id)
//    }

//    suspend fun getAll(): List<TaskModel>  = withContext(IO){
//        return@withContext dao.getAll().map { it.toTask() }
//    }

   suspend fun updateTask(task: TaskModel) {
        dao.updateTask(task.toEntity())
    }
}

fun TaskModel.toEntity() = TaskEntity(
    id = this.id,
    title = this.title,
    description = this.description,
    status = this.status,

)

fun TaskEntity.toTaskModel() = TaskModel(
    id = this.id,
    title = this.title,
    description = this.description,
    status = this.status,


)


