package com.example.taskapp.state

import com.example.taskapp.models.TaskModel

data class TasksListUiState(
    val tasks:List<TaskModel> = emptyList(),
    val onTaskDoneChange: (TaskModel) -> Unit = {}
)