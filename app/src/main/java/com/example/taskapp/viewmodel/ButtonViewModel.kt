package com.example.taskapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//class ButtonViewModel: ViewModel() {
//    private val _button = mutableStateOf<Int>(0)
//    val button: MutableState<Int> = _button
//
//    val taskPendentes = mutableStateListOf<String>()
//    val taskProgresso = mutableStateListOf<String>()
//    val taskTerminada = mutableStateListOf<String>()
//
//    fun buttonProgre(newButton:Int){
//        _button.value = newButton
//    }
//
//    fun isEmpty(status: Int):Boolean{
//        return when (status) {
//            1 -> taskPendentes.isEmpty()
//            2 -> taskProgresso.isEmpty()
//            3 -> taskTerminada.isEmpty()
//            else -> true
//        }
//    }
//}


