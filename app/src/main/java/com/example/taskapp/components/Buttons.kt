package com.example.taskapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.ui.theme.backButton
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.progressBarColor
import com.example.taskapp.ui.theme.redbutton
import com.example.taskapp.ui.theme.texthin
import com.example.taskapp.viewmodel.ButtonViewModel
import com.example.taskapp.viewmodel.ChangeViewModel

@Composable
fun screen(){
    Column (modifier = Modifier.fillMaxSize()){
        taskButton(tittle = "Crie uma task", rememberNavController(), "task")
        progressButton()

    }
}

@Composable
fun taskButton(tittle:String, navController: NavController, route:String){
    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        Box(modifier = Modifier
            .height(48.dp)
            .width(327.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(buttonBlue)
            .clickable { navController.navigate(route) },
            contentAlignment = Alignment.Center
        ){
            Text(text = tittle, fontSize = 12.sp, color = Color.White)
        }
    }
//    Box(modifier = Modifier
//        .height(48.dp)
//        .width(327.dp)
//        .clip(RoundedCornerShape(5.dp))
//        .background(buttonBlue)
//        .clickable { navController.navigate(route) },
//        contentAlignment = Alignment.Center
//    ){
//        Text(text = tittle, fontSize = 12.sp, color = Color.White)
//    }
}


@Composable
fun progressButton() {
    //val selected = remember { mutableStateOf(0) }

    val buttonViewModel = viewModel<ButtonViewModel>()

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(progressBarColor),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(31.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (buttonViewModel.button.value == 1) Color.White else progressBarColor)
                    .clickable { buttonViewModel.button.value = 1 },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Pendentes", color = texthin, fontSize = 12.sp)
            }
            Text(text = "|", color = texthin)
            Box(
                modifier = Modifier
                    .height(31.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (buttonViewModel.button.value == 2) Color.White else progressBarColor)
                    .clickable { buttonViewModel.button.value = 2 },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Em Progresso", color = texthin, fontSize = 12.sp)
            }
            Text(text = "|", color = texthin)
            Box(
                modifier = Modifier
                    .height(31.dp)
                    .width(110.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (buttonViewModel.button.value == 3) Color.White else progressBarColor)
                    .clickable { buttonViewModel.button.value = 3 },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Terminados", color = texthin, fontSize = 12.sp)
            }

        }

    }
}


@Composable
fun changeButton(){
    Box(modifier = Modifier
        .height(24.dp)
        .width(89.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(backButton)
        .clickable {},
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Alterar", fontSize = 10.sp, color = buttonBlue)
    }
}

@Composable
fun saveButton(){
    Box(modifier = Modifier
        .height(24.dp)
        .width(89.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(redbutton)
        .clickable {},
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "TERMINADO", fontSize = 10.sp, color = Color.White)
    }
}

@Preview
@Composable
fun taskButtonPreview(){
    screen()
}