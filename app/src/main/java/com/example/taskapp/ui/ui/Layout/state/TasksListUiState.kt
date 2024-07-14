package com.example.taskapp.ui.ui.Layout.state

import com.example.taskapp.models.TaskModel

data class TasksListUiState(
    val tasks:List<TaskModel> = emptyList(),
    val onTaskChange: (TaskModel) -> Unit = {} //Não sei se isso é para o toggle
)