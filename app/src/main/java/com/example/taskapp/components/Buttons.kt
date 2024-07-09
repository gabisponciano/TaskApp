package com.example.taskapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.progressBarColor
import com.example.taskapp.ui.theme.texthin

@Composable
fun screen(){
    Column (modifier = Modifier.fillMaxSize()){
        taskButton(tittle = "Crie uma task")
        progressButton()

    }
}

@Composable
fun taskButton(tittle:String){
    Box(modifier = Modifier
        .height(48.dp)
        .width(327.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(buttonBlue)
        .clickable {

        },
        contentAlignment = Alignment.Center
    ){
        Text(text = tittle, fontSize = 12.sp, color = Color.White)
    }
}


@Composable
fun progressButton(){

    Box (
        modifier = Modifier
            .width(343.dp)
            .height(39.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(progressBarColor),
        contentAlignment = Alignment.Center
    ){
        Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)){
            Text(text = "Pendentes", color = texthin)
            Text(text = "|", color = texthin)
            Text(text = "Em Progresso", color = texthin)
            Text(text = "|", color = texthin)
            Text(text = "Terminados", color = texthin)
        }

    }

}

@Preview
@Composable
fun taskButtonPreview(){
    screen()
}