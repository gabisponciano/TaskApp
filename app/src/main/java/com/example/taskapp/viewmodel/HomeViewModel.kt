package com.example.taskapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskapp.models.TaskModel
import com.example.taskapp.repository.TaskRepository
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel (private val repository:TaskRepository):ViewModel(){

    var itemSelected by mutableIntStateOf(1)
    var listAll by mutableStateOf<Array<TaskModel>?>(null)
    var listStatus by mutableStateOf(listOf("Pendentes","Em Progresso", "Terminado"))
    private val tempListModel = mutableListOf<TaskModel>()

    init {
        viewModelScope.launch {
            getAllTasks()
        }
    }

    private suspend fun getAllTasks(){
        try {
            val resultList = repository.getAll()
            for (i in resultList.indices){
                tempListModel.add(resultList[i])
                println("${tempListModel[i].title} home-viewmodel")
            }
        }catch (e:Exception){
            println(e.message)
        }
    }

    suspend fun save(
        title:String,
        description: String,
        status: String
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