package com.example.taskapp.ui.ui.Layout.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.models.TaskModel
import com.example.taskapp.repository.TaskRepository
import com.example.taskapp.ui.ui.Layout.state.TaskFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    private val _uiState:MutableStateFlow<TaskFormUiState> = MutableStateFlow(TaskFormUiState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onTitleChange = { title ->
                    _uiState.update {
                        it.copy(title = title)
                    }

                },
                onDescriptionChange = { description ->
                    _uiState.update {
                        it.copy(description = description)
                    }
                },
                onStatusChange = {status ->
                    _uiState.update {
                        it.copy(status = status)
                    }

                }
            )

        }


    }


    fun loadTask(task: TaskModel) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                title = task.title,
                description = task.description,
                status = task.status
            )
        }
    }


    fun clearFields(){
        _uiState.update { it.copy(
            title = "",
            description = "",
            status = ""
        ) }
    }

     fun delete(task: TaskModel){
        viewModelScope.launch {
            repository.deleteTask(task)
        }

    }

     fun update(task: TaskModel){
        val _task = TaskModel(
            id = task.id,
            title = _uiState.value.title,
            description = _uiState.value.description,
            status = _uiState.value.status
        )
         viewModelScope.launch {
             repository.updateTask(_task)
         }
    }


    suspend fun save(){
        val task = TaskModel(
            title = _uiState.value.title,
            description = _uiState.value.description,
            status =  _uiState.value.status
        )
        viewModelScope.launch {
            repository.save(task)
        }
    }

}

