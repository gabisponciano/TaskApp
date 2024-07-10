package com.example.taskapp.screens

import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.components.LockScreenOrientation
import com.example.taskapp.components.progressButton
import com.example.taskapp.components.taskButton
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.texthin
import com.example.taskapp.viewmodel.ButtonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(navController: NavHostController){
    val buttonViewModel = viewModel<ButtonViewModel>()
    LockScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
//    val showSearch = remember { mutableStateOf(false) }
//    val searchText = remember { mutableStateOf(TextFieldValue("")) }
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
            taskButton(tittle = "Criar uma Task") {
                navController.navigate("task")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(260.dp),
        ) {
            Box(modifier = Modifier.height(39.dp)){
                progressButton()
            }
            StatusCard(buttonViewModel.button.value, buttonViewModel )
//            Box (modifier = Modifier
//                .height(118.dp)
//                .width(375.dp),
//                contentAlignment = Alignment.Center){
//                Column (horizontalAlignment = Alignment.CenterHorizontally){
//                    Text(text = "Nada aqui. Por agora.",
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center
//                    )
//
//                    Text(text = "É aqui que você encontrará seus projetos finalizados.",
//                        fontSize = 14.sp,
//                        color = texthin,
//                        textAlign = TextAlign.Center
//                        )
//                }
//            }

        }
    }
}


@Composable
fun StatusCard(status: Int, viewModel: ButtonViewModel){
    if (viewModel.isEmpty(status)){
        Box (modifier = Modifier
            .height(118.dp)
            .width(375.dp),
            contentAlignment = Alignment.Center){
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Text(text = "Nada aqui por agora.",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Text(text = "É aqui que você encontrará seus projetos.",
                    fontSize = 14.sp,
                    color = texthin,
                    textAlign = TextAlign.Center
                )
            }
        }
    }else {
        when(status){
            1 -> taskPendentesCard()
            2 -> taskProgressoCard()
            3 -> taskTerminadaCard()
        }
    }
}

@Composable
fun taskPendentesCard(){
    ListTask(tittle = "Alguma", description ="hdkc" , status = "Pendente")
}

@Composable
fun taskProgressoCard(){
    ListTask(tittle = "Alguma", description ="hdkc" , status = "Prgressp")
}

@Composable
fun taskTerminadaCard(){
    ListTask(tittle = "Alguma", description ="hdkc" , status = "Terminado")
}


@Preview
@Composable
fun HomePreview(){
    homeScreen(navController = rememberNavController())
}