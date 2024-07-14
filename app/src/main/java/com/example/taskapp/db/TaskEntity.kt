package com.example.taskapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity
data class TaskEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val status: String,
)