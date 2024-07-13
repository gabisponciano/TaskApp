package com.example.taskapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.models.TaskModel
import com.example.taskapp.repository.TaskRepository
import com.example.taskapp.repository.toTask
import com.example.taskapp.state.TasksListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel (private val repository:TaskRepository):ViewModel(){

    private val _uiState: MutableStateFlow<TasksListUiState> = MutableStateFlow(TasksListUiState())

    val uiState
        get() = _uiState
            .combine(repository.tasks){ uiState, tasks ->
                uiState.copy(tasks = tasks.map{it.toTask()})
            }
//    init {
//        viewModelScope.launch {
//            _uiState.update { currentState ->
//                currentState.copy(onTaskDoneChange = { task ->
//                    viewModelScope.launch {
//                        repository
//                    }
//
//                })
//            }
//        }
//    }

}