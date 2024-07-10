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
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query ("SELECT * FROM Task WHERE id = :id")
    suspend fun deleteTask(id:String)

    @Query("SELECT * FROM Task")
    suspend fun findAll():Flow<List<Task>>

    @Update()
    suspend fun uptadeTask(task: Task)




}