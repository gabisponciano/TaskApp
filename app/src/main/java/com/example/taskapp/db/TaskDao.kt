package com.example.taskapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


//@Dao
//interface TaskDao {
//    //Precisa de Uptade, Deletar, Criar e Procurar
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE) // Atualiza e Insere
//    suspend fun insertTask(task: TaskEntity)
//
//    @Delete
//    suspend fun deleteTask(task: TaskEntity)
//
//    @Query ("SELECT * FROM TaskEntity WHERE id = :id")
//    suspend fun deleteTaskId(id:String)
//
//    @Query("SELECT * FROM TaskEntity")
//    fun findAll():Flow<List<TaskEntity>>
//
//    @Update()
//    suspend fun uptadeTask(task: TaskEntity)
//
//}