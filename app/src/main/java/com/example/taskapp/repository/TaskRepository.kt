package com.example.taskapp.repository

//import com.example.taskapp.db.TaskDao
//import com.example.taskapp.db.TaskEntity
//import com.example.taskapp.models.Task
//import kotlinx.coroutines.Dispatchers.IO
//import kotlinx.coroutines.withContext
//
//class TaskRepository (
//    private val dao: TaskDao
//){
//    val allTasks get() = dao.findAll()
//
//    suspend fun insert(task: Task) = withContext(IO){
//        dao.insertTask(task.toEntity())
//    }
//
//    suspend fun deleteId(id:String) = withContext(IO){
//        dao.deleteTaskId(id)
//    }
//
//    suspend fun delete(task: Task) = withContext(IO){
//        dao.deleteTask(task.toEntity())
//    }
//
//
//}
//
//
//fun TaskEntity.toTask() = Task(
//    id = this.id,
//    title = this.title,
//    description = this.description,
//    status = this.status
//
//)
//
//fun Task.toEntity() = TaskEntity(
//    id = this.id,
//    title = this.title,
//    description = this.description,
//    status = this.status
//)



