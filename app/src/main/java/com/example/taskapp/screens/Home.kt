package com.example.taskapp.screens

import android.content.pm.ActivityInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.taskapp.components.CardItem
import com.example.taskapp.components.LockScreenOrientation
import com.example.taskapp.components.taskButton
import com.example.taskapp.models.TaskModel
import com.example.taskapp.ui.theme.buttonBlue
import com.example.taskapp.ui.theme.texthin
import com.example.taskapp.viewmodel.HomeViewModel
import com.example.taskapp.viewmodel.TaskViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(navController: NavHostController){
    val homeViewModel = koinViewModel<HomeViewModel>()

 //   val tasks by taskViewModel.tasks.observeAsState(initial = emptyList())
//    val buttonViewModel = viewModel<ButtonViewModel>()

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
            taskButton(title = "Criar uma Task") {
                navController.navigate("task")
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Box(modifier = Modifier.height(39.dp)){

            }

            if (homeViewModel.listAll == null){
                emptyTasks()

            }else{
                homeViewModel.listAll?.forEachIndexed { _, task ->
                CardItem(task.title,task.description,task.status)
                }
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
}



//@Composable
//fun StatusCard(status: Int, viewModel: ButtonViewModel){
//    if (viewModel.isEmpty(status)){
//        Box (modifier = Modifier
//            .height(118.dp)
//            .width(375.dp),
//            contentAlignment = Alignment.Center){
//            Column (horizontalAlignment = Alignment.CenterHorizontally){
//                Text(text = "Nada aqui por agora.",
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold,
//                    textAlign = TextAlign.Center
//                )
//
//                Text(text = "É aqui que você encontrará seus projetos.",
//                    fontSize = 14.sp,
//                    color = texthin,
//                    textAlign = TextAlign.Center
//                )
//            }
//        }
//    }else {
//        when(status){
//            1 -> taskPendentesCard()
//            2 -> taskProgressoCard()
//            3 -> taskTerminadaCard()
//        }
//    }
//}
//
//@Composable
//fun taskPendentesCard(){
//    ListTask(tittle = "Alguma", description ="hdkc" , status = "Pendente")
//}
//
//@Composable
//fun taskProgressoCard(){
//    ListTask(tittle = "Alguma", description ="hdkc" , status = "Prgressp")
//}
//
//@Composable
//fun taskTerminadaCard(){
//    ListTask(tittle = "Alguma", description ="hdkc" , status = "Terminado")
//}
@Composable
fun emptyTasks(){
    Box (modifier = Modifier
        .height(118.dp)
        .width(375.dp),
    contentAlignment = Alignment.Center){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
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


//@Composable
//fun TaskCard(task: TaskModel) {
//    OutlinedCard(
//        modifier = Modifier
//            .height(170.dp)
//            .width(327.dp),
//        colors = CardDefaults.outlinedCardColors(
//            containerColor = Color.Transparent
//        )
//    ) {
//        Column {
//            Row(modifier = Modifier.padding(5.dp)) {
//                Text(text = "Título", fontSize = 14.sp, fontWeight = FontWeight.Bold)
//                Spacer(modifier = Modifier.width(178.dp))
//                Text(text = task.title, fontSize = 14.sp)
//            }
//            Row(modifier = Modifier.padding(5.dp)) {
//                Text(text = "Descrição", fontSize = 14.sp, fontWeight = FontWeight.Bold)
//                Spacer(modifier = Modifier.width(151.dp))
//                Text(text = task.description, fontSize = 14.sp)
//            }
//            Row(modifier = Modifier.padding(5.dp)) {
//                Text(text = "Status", fontSize = 14.sp, fontWeight = FontWeight.Bold)
//                Spacer(modifier = Modifier.width(173.dp))
//                Box(
//                    modifier = Modifier
//                        .height(24.dp)
//                        .width(89.dp)
//                        .clip(RoundedCornerShape(10.dp))
//                        .background(buttonBlue), // Substitua por sua cor real
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = task.status, fontSize = 10.sp, color = Color.White)
//                }
//            }
//        }
//    }
//}


@Preview
@Composable
fun HomePreview(){
    homeScreen(navController = rememberNavController())
}