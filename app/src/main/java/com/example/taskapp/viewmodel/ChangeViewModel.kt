package com.example.taskapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ChangeViewModel: ViewModel() {
    private val _tittle = mutableStateOf<String>("")
    val tittle: MutableState<String> = _tittle

    private val _pressed = mutableStateOf<Boolean>(false)
    val pressed: MutableState<Boolean> = _pressed

    private val _description = mutableStateOf<String>("")
    val description: MutableState<String> = _description


    fun tittleTask(newTask:String){
        _tittle.value = newTask
    }

    fun descriptionTask(newDescription:String){
        _description.value = newDescription
    }

}