package com.example.taskapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.taskapp.db.TaskEntity
import com.example.taskapp.models.TaskModel
import com.example.taskapp.repository.TaskRepository
import com.example.taskapp.state.TaskFormUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

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
                onDescriptionStatus = {status ->
                    _uiState.update {
                        it.copy(status = status)
                    }

                }
            )

        }


    }


    suspend fun save(){
        with(_uiState.value){
            repository.save(
                TaskModel(
                    title = title,
                    description = description,
                    status = status
                )
            )
        }
    }

}

