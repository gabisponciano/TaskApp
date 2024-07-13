package com.example.taskapp.state

data class TaskFormUiState(
    val title:String = "",
    val description: String = "",
    val status: String = "",
    val onTitleChange: (String) -> Unit = {},
    val onDescriptionChange:(String) -> Unit = {},
    val onDescriptionStatus:(String) -> Unit  = {}
)