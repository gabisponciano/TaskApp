package com.example.taskapp.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ButtonViewModel: ViewModel() {
    private val _button = mutableStateOf<Int>(0)
    val button: MutableState<Int> = _button


    fun buttonProgre(newButton:Int){
        _button.value = newButton
    }


}