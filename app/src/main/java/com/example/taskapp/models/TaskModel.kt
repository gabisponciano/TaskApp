package com.example.taskapp.models

import java.util.UUID

class TaskModel (
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val status: String,

)