package com.example.taskapp.ui.ui.Layout.viewmodel

import androidx.lifecycle.ViewModel
import com.example.taskapp.repository.TaskRepository
import com.example.taskapp.repository.toTaskModel
import com.example.taskapp.ui.ui.Layout.state.TasksListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class HomeViewModel (private val repository:TaskRepository):ViewModel(){

    private val _uiState: MutableStateFlow<TasksListUiState> = MutableStateFlow(TasksListUiState())

    val uiState
        get() = _uiState
            .combine(repository.getAllTasks){uiState, tasks ->
                uiState.copy(tasks = tasks.map { it.toTaskModel() })

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