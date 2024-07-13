package com.example.taskapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {
    //Precisa de Uptade, Deletar, Criar e Procurar

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Atualiza e Insere
    suspend fun save(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Query ("DELETE FROM TaskEntity WHERE id = :id")
    suspend fun deleteTaskId(id:Int)

    @Query("SELECT * FROM TaskEntity")
    fun getAll():Flow<List<TaskEntity>>

    @Update()
    suspend fun updateTask(task: TaskEntity)

}