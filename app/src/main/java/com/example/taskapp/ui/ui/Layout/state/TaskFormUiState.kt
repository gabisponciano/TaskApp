package com.example.taskapp.ui.ui.Layout.state

data class TaskFormUiState(
    val title:String = "",
    val description: String = "",
    val status: String = "",
    val onTitleChange: (String) -> Unit = {},
    val onDescriptionChange:(String) -> Unit = {},
    val onDescriptionStatus:(String) -> Unit  = {}
)