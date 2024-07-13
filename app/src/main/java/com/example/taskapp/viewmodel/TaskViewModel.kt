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
import kotlinx.coroutines.launch
import java.util.UUID

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var status by mutableStateOf("")



    fun clearFilds(){
        title = ""
        description = ""
        status = ""
    }

    fun saveTask(){
        if(
            title.isNotEmpty() &&
            description.isNotEmpty()
        ){
            viewModelScope.launch {
                save(title,description,status)
            }
        }

    }

    private suspend fun save(
        title:String,
        description:String,
        status:String
    ){
        repository.save(
            TaskModel(
                id = UUID.randomUUID().toString(),
                title = title,
                description = description,
                status = status
            )
        )
    }
}

