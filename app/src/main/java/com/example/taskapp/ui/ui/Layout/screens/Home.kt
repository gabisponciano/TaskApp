package com.example.taskapp.ui.ui.Layout.screens

import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.taskapp.R
import com.example.taskapp.ui.ui.Layout.components.CardItem
import com.example.taskapp.ui.ui.Layout.components.LockScreenOrientation
import com.example.taskapp.ui.ui.Layout.components.taskButton
import com.example.taskapp.ui.ui.Layout.state.TasksListUiState
import com.example.taskapp.ui.ui.Layout.buttonBlue
import com.example.taskapp.ui.ui.Layout.texthin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, uiState: TasksListUiState, onSaveClick: ()-> Unit){

    val scope = rememberCoroutineScope()

    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(5.dp),
                colors = topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text("Projeto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp)
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = buttonBlue)

                    }
                }
            )
        },
        bottomBar = {
            taskButton(title = "Criar uma Task") {
                navController.navigate("task")
            }
        },
    ) { innerPadding ->
            if(uiState.tasks.isEmpty()){
                Column ( modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    emptyTasks()
                }
            }else{
                LazyColumn ( modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.White)){
                    itemsIndexed(uiState.tasks){_, task->
                        CardItem(task, navController)

                    }
                }
            }
    }
}



@Composable
fun emptyTasks(){
    Box (modifier = Modifier
        .fillMaxSize(),
    contentAlignment = Alignment.Center){
    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()

        ){
        Image(painterResource(R.drawable.imagemnotas), contentDescription = null,
            modifier = Modifier.size(100.dp))
        Text(text = "Nada aqui. Por agora.",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(text = "É aqui que você encontrará seus projetos finalizados.",
            fontSize = 14.sp,
            color = texthin,
            textAlign = TextAlign.Center
            )
    }
}
}




@Preview
@Composable
fun HomePreview(){
    emptyTasks()
}